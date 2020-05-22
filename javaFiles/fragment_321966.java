package com.test.downloadjpgtest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;


public class DownloadTask extends AsyncTask<String, Void, String> {
    private Activity activity;

    public DownloadTask(Activity activity){
        this.activity = activity;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... args) {       
        int idx = 0;
        for (String urlString : args) {     
            String name = Integer.toString(++idx)+".jpg";
            URL url = null;
            try {
                url = new URL(urlString);
            } catch (MalformedURLException ex) {
                Log.e("DownloadTask","MalformedURLException",ex);
            }
            saveFileOnDisk(url, name);
        }
        return "ok"; // just to return a string
    }

    protected String saveFileOnDisk(URL url, String outputName){
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(url.openConnection().getInputStream());
            File directory = DownloadTask.getImageDirectory(this.activity);
            File newFile = new File(directory, outputName);

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
            int bytesRead;
            byte[] data = new byte[4096];
            while ((bytesRead = bis.read(data)) != -1){
                bos.write(data, 0, bytesRead);
            }
            Log.d("DownloadTask", "writing data bos " + directory.getAbsolutePath() + '/' + outputName);
            bos.flush();
            bos.close();
            return newFile.getAbsolutePath();
        } catch (Exception ex) {
            Log.e("DownloadTask","Failed to download or write image file",ex);
        } finally {
            if (bis != null)
                try { 
                    bis.close(); 
                }
                catch (Exception ex) {
                    Log.e("DownloadTask","Failed to gracefully close input stream",ex);
                }
        }
        return "ko";
    }

    protected void onProgressUpdate(String... progress) {
        Log.i("progress", progress[0]);
    }

    public static File[] getImages(Context ctxt)
    {
        File[] files = getImageDirectory(ctxt).listFiles();
        return files;
    }

    public static File getImageDirectory(Context ctxt)
    {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        //return ctxt.getDir("jpgfolder", Context.MODE_PRIVATE);
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            Log.d("DownloadTask", "All downloads finished");
            // check downloaded files
            File[] filesInDirectory = DownloadTask.getImages(this.activity);
            for(int i=0, max = filesInDirectory.length; i < max; i++){
                Log.i("DownloadTask", "onPostExecute: file " + i + " > " + filesInDirectory[i]);
            }
            // set grid adapter ... cf Main.java
            ((Main) this.activity).setGridAdapter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}