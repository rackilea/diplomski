import com.google.common.io.Files;
import com.squareup.okhttp.ResponseBody;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String... args) {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl("http://repo1.maven.org").
                build();

        RetrofitDownload retrofitDownload = retrofit.create(RetrofitDownload.class);

        Call<ResponseBody> call = retrofitDownload.downloadRetrofit("retrofit-2.0.0-beta2.jar");

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> response, Retrofit retrofitParam) {
                File file = new File("retrofit-2.0.0-beta2.jar");
                try {
                    file.createNewFile();
                    Files.asByteSink(file).write(response.body().bytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });
    }
}