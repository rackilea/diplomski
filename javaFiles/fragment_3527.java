import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.auth.http.HttpTransportFactory;

DatastoreOptions.newBuilder()
    .setHttpTransportFactory(new HttpTransportFactory() {
      @Override
      public HttpTransport create() {
        return new NetHttpTransport();
      }
    })
    ...