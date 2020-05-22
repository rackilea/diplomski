public static NFCPlatform getNFCPlatform() {
    try {
        if ("android".equals(System.getProperty("javafx.platform", "desktop"))) {
            return (NFCPlatform) Class.forName("<your package>.AndroidNFCPlatform").newInstance();
        }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        System.out.println("Error " + ex);
    }
    return null;
}

@Override
public void start(Stage stage) {

    NFCService nfcService = getNFCPlatform().getNFCService();

    if (nfcService != null) {
        System.out.println("Available: " + nfcService.isAvailable());

        ...
    }
}