package com.example;

import android.net.Uri;
import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class AvatarDownloaderTask extends AsyncTask<String, String, Avatar> {

    private OnTaskCompleted _listener;

    public AvatarDownloaderTask(OnTaskCompleted listener){
        _listener = listener;
    }


    @Override
    protected Avatar doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(params[0])
                .head()
                .build();

        try {
            okhttp3.Response response = client.newCall(request).execute();

            if (Integer.parseInt(response.header("Content-Length")) > 100) {
                return new Avatar(AvatarType.TYPE_Y, Uri.parse(params[0]));
            }
        } catch (IOException e) {
            cancel(true);
        }
        return new Avatar(AvatarType.TYPE_X, Uri.parse(params[0]));
    }

    @Override
    protected void onPostExecute(Avatar s) {
        super.onPostExecute(s);
        _listener.onTaskCompleted(s);
    }

    @Override
    protected void onCancelled(Avatar s) {
        super.onCancelled(s);
        _listener.onTaskCompleted(s);
    }

    public interface OnTaskCompleted{
        void onTaskCompleted(Avatar avatar);
    }
}