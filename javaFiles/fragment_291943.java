public class AndroidNFCService implements NFCService, ReaderCallback {

    private final NfcAdapter nfcAdapter;
    private StringProperty tagId;

    public AndroidNFCService() {
        NfcManager manager = (NfcManager) FXActivity.getInstance().getSystemService(FXActivity.NFC_SERVICE);
        nfcAdapter = manager.getDefaultAdapter();
    }

    @Override
    public boolean isAvailable() {
        return nfcAdapter != null;
    }

    @Override
    public boolean isEnabled() {
        return isAvailable() && nfcAdapter.isEnabled();
    }

    @Override
    public StringProperty tagIdProperty() {
        if (tagId == null) {
            tagId = new SimpleStringProperty();
        }
        return tagId;
    }

    @Override
    public void onTagDiscovered(Tag tag) {
        Platform.runLater(() -> 
            tagIdProperty().set(new String(tag.getId())));
    }

}