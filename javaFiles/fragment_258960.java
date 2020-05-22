import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;

import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;


import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.params.HttpParams;

import android.annotation.TargetApi;
import android.net.SSLCertificateSocketFactory;
import android.os.Build;


 class SslSocketFactory extends SSLSocketFactory {

     InputStream mkeyStore;
     String mkeyStorePassword;

     public SslSocketFactory(InputStream keyStore, String keyStorePassword) throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException{
         super(null);
         mkeyStore=keyStore;
         mkeyStorePassword=keyStorePassword;

     }



      @Override
      public Socket connectSocket(Socket s, String host, int port, InetAddress localAddress, int localPort, HttpParams params) throws IOException {
          return null;
      }

      @Override
      public Socket createSocket() throws IOException {
          return null;
      }

      @Override
      public boolean isSecure(Socket s) throws IllegalArgumentException {
          if (s instanceof SSLSocket) {
              return ((SSLSocket) s).isConnected();
          }
          return false;
      }

      @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
      @Override
      public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
          SSLSocket sslSocket = null;


              if (autoClose) {
                  socket.close();
              }


                 SSLCertificateSocketFactory sslSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0, null);


              try {
                sslSocketFactory.setTrustManagers(new TrustManager[] { new SsX509TrustManager( mkeyStore, mkeyStorePassword) });
            } catch (GeneralSecurityException e1) {

                e1.printStackTrace();
            }



              sslSocket = (SSLSocket) sslSocketFactory.createSocket(InetAddress.getByName(host), port);

              sslSocket.setEnabledProtocols(sslSocket.getSupportedProtocols());

              if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

                  sslSocketFactory.setHostname(sslSocket, host);
              } else {

                  try {
                      java.lang.reflect.Method setHostnameMethod = sslSocket.getClass().getMethod("setHostname", String.class);
                      setHostnameMethod.invoke(sslSocket, host);
                  } catch (Exception e) {

                  }
              }


          return sslSocket;
      }

  }