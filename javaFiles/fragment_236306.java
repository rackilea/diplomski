package com.example.shadowsheep.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView helloTextView = findViewById(R.id.helloTextView);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .callTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .readTimeout(5, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();

        Request request = new Request.Builder()
                .url("https://www.versionestabile.it/blog")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.d("OKHTTP3", e.getMessage());
                // You get this failure
                runOnUiThread(() -> helloTextView.setText("TIMEOUT - FAILURE -> " + e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    final String _body = response.body().string();
                    Log.d("OKHTTP3", _body);
                    runOnUiThread(() -> {
                        helloTextView.setText(_body);
                    });
                } catch (InterruptedIOException e) {
                    runOnUiThread(() -> {
                        // Or this exception depending when timeout is reached
                        helloTextView.setText("TIMEOUT EXCEPTION->"+ e.getCause() + ": " + e.getMessage());
                    });
                }
            }
        });
    }
}