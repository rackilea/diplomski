package com.jeff;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.squareup.okhttp.CipherSuite;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.TlsVersion;

public class Tester {

    public static void main(String[] args) throws IOException {

        String httpUrl = "https://api.sandbox.paypal.com/retail/merchant/v1/invoices/";
        String jsonContent = "{'test':'test'}";

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonContent);
        Request request =  new Request.Builder().url(httpUrl).post(requestBody).build();
        OkHttpClient okHttpClient = new OkHttpClient();

        okHttpClient.setConnectionSpecs(createConnectionSpecs(okHttpClient));

        Response response = okHttpClient.newCall(request).execute();

        System.out.println(response.body());
    }

      private static List<ConnectionSpec> createConnectionSpecs(OkHttpClient okHttpClient) {
        ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)  
            .tlsVersions(TlsVersion.TLS_1_2)
            .cipherSuites(
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA,
                CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA,
                CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA)
            .build();
        return Collections.singletonList(spec);
      }

}