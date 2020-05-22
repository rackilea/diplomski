...
import org.apache.http.client.methods.HttpPost;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.Consts;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.HttpEntity;
....

public String sendPost(String url, Map<String, String> postParams, 
        Map<String, String> header, String cookies) {

    HttpPost httpPost = new HttpPost(url);
    List<NameValuePair> formParams = new ArrayList<NameValuePair>();
    HttpClientBuilder clientBuilder = HttpClients.createDefault();
    CloseableHttpClient httpclient = clientBuilder.build();

    if (header != null) {
        Iterator<Entry<String, String>> itCabecera = header.entrySet().iterator();
        while (itCabecera.hasNext()) {
            Entry<String, String> entry = itCabecera.next();

            httpPost.addHeader(entry.getKey(), entry.getValue());
        }
    }

    httpPost.setHeader("Cookie", cookies);

    if (postParams != null) {
        Iterator<Entry<String, String>> itParms = postParams.entrySet().iterator();
        while (itParms.hasNext()) {
            Entry<String, String> entry = itParms.next();

            formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
    }

    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
    httpPost.setEntity(formEntity);

    CloseableHttpResponse httpResponse = httpclient.execute(httpPost);

    HttpEntity entity = httpResponse.getEntity();
    if (entity != null) {
        pageContent = EntityUtils.toString(entity);
    }

    return pageContent;
}