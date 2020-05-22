import org.bouncycastle.crypto.tls.DefaultTlsClient;

public class NewDefaultTlsClient extends DefaultTlsClient{

    @Override
    public void notifySecureRenegotiation(boolean secureRenegotiation){
        //do nothing here
    }

    @Override
    public org.bouncycastle.crypto.tls.TlsAuthentication getAuthentication()
            throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

}