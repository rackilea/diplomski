public class AndroidNFCPlatform extends NFCPlatform {

    private AndroidNFCService nfcService;

    @Override
    public NFCService getNFCService() {
        if (nfcService == null) {
            nfcService = new AndroidNFCService();
        }
        return nfcService;
    }

}