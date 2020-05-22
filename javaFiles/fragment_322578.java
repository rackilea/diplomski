package com.Firstlambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.ItemUtils;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent.DynamodbStreamRecord;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HelloWorld implements RequestHandler<DynamodbEvent, String> {
    private static String serviceName = "es";
    private static String region = "us-east-1";
    private static String aesEndpoint = ""
    private static String index = "";
    private static String type = "_doc";

    static final AWSCredentialsProvider credentialsProvider = new DefaultAWSCredentialsProviderChain();

    public String handleRequest(DynamodbEvent ddbEvent, Context context) {
        for (DynamodbStreamRecord record : ddbEvent.getRecords()) {
            System.out.println("EventName : " + record.getEventName());
            System.out.println("EventName : " + record.getDynamodb());

            //AWS outside
            RestHighLevelClient esClient = esClient();
            //AWS outside

            //AWS Inside
            //RestHighLevelClient esClient = esClient(serviceName, region);
            //AWS Inside
            if (record.getEventName().toLowerCase().equals("insert")) {
                String JsonString = getJsonstring(record.getDynamodb().getNewImage());
                String JsonUniqueId = GetIdfromJsonString(JsonString);
                IndexRequest indexRequest = new IndexRequest(index, type, JsonUniqueId);
                indexRequest.source(JsonString, XContentType.JSON);
                try {
                    IndexResponse indexResponse = esClient.index(indexRequest, RequestOptions.DEFAULT);
                    System.out.println(indexResponse.toString());
                    return "Successfully processed " + ddbEvent.getRecords().size() + " records.";
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else if (record.getEventName().toLowerCase().equals("modify")) {
                String JsonString = getJsonstring(record.getDynamodb().getNewImage());
                String JsonUniqueId = GetIdfromJsonString(JsonString);
                UpdateRequest request = new UpdateRequest(index, type, JsonUniqueId);
                String jsonString = JsonString;
                request.doc(jsonString, XContentType.JSON);
                try {
                    UpdateResponse updateResponse = esClient.update(
                            request, RequestOptions.DEFAULT);
                    System.out.println(updateResponse.toString());
                    return "Successfully processed " + ddbEvent.getRecords().size() + " records.";
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("remove");
                System.out.println("KEYID : " + record.getDynamodb().getKeys().get("ID").getN());
                String deletedId = record.getDynamodb().getKeys().get("ID").getN();
                DeleteRequest request = new DeleteRequest(index, type, deletedId);
                try {
                    DeleteResponse deleteResponse = esClient.delete(
                            request, RequestOptions.DEFAULT);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return "Successfullyprocessed";
    }

    public String getJsonstring(Map<String, AttributeValue> newIma) {
        String json = null;
        Map<String, AttributeValue> newImage = newIma;
        List<Map<String, AttributeValue>> listOfMaps = new ArrayList<Map<String, AttributeValue>>();
        listOfMaps.add(newImage);
        List<Item> itemList = ItemUtils.toItemList(listOfMaps);
        for (Item item : itemList) {
            json = item.toJSON();
        }
        return json;
    }

    public String GetIdfromJsonString(String Json) {
        JSONObject jsonObj = new JSONObject(Json);
        return String.valueOf(jsonObj.getInt("ID"));
    }

    // Adds the interceptor to the ES REST client
//    public static RestHighLevelClient esClient(String serviceName, String region) {
//        AWS4Signer signer = new AWS4Signer();
//        signer.setServiceName(serviceName);
//        signer.setRegionName(region);
//        HttpRequestInterceptor interceptor = new AWSRequestSigningApacheInterceptor(serviceName, signer, credentialsProvider);
//        return new RestHighLevelClient(RestClient.builder(HttpHost.create(aesEndpoint)).setHttpClientConfigCallback(hacb -> hacb.addInterceptorLast(interceptor)));
//    }

    public static RestHighLevelClient esClient() {
        String host = "d9bc7cbca5ec49ea96a6ea683f70caca.eastus2.azure.elastic-cloud.com";

        int port = 9200;

        String userName = "elastic";

        String password = "L4Nfnle3wxLmV95lffwsf$Ub46hp";

        String protocol = "https";

        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(userName, password));

        RestClientBuilder builder = RestClient.builder(new HttpHost(host, port, protocol))
                .setHttpClientConfigCallback(httpClientBuilder -> httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));

        RestHighLevelClient client = new RestHighLevelClient(builder);
        return client;
    }

}