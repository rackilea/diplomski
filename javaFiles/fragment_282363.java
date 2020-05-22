package com.example.erwan.ftplearn;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

import java.io.IOException;
import java.net.InetAddress;

public class FTPModel {
    public FTPClient mFTPClient = null;

    public boolean connect(String host, String username, String password, int port)
    {
        try
        {
            return new asyncConnexion(host, username, password, port).execute().get();
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public class asyncConnexion extends AsyncTask<Void, Void, Boolean>
    {
        private String host;
        private String username;
        private String password;
        private int port;

        asyncConnexion(String host, String username, String password, int port)
        {
            this.host = host;
            this.password = password;
            this.port = port;
            this.username = username;
        }


        @Override
        protected Boolean doInBackground(Void... voids) {
            try {

                mFTPClient = new FTPClient();
                // connecting to the host
                mFTPClient.connect(host, port);

                // now check the reply code, if positive mean connection success
                boolean status = mFTPClient.login(username, password);

                mFTPClient.setFileType(FTP.BINARY_FILE_TYPE);
                mFTPClient.enterLocalPassiveMode();
                return status;

            } catch (Exception e) {
                Log.i("testConnection", "Error: could not connect to host " + host);
                e.printStackTrace();

            }
            return false;
        }
    }
}