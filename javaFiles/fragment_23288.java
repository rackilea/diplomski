public static void main(String... args) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

       //this is what you're looking for - a way to download a file using 'webContentLink'
        try {        
              Desktop desktop = java.awt.Desktop.getDesktop();
              //place your webContentLink in the oURL variable
              URI oURL = new URI("https://drive.google.com/a/google.com/uc?id=YOUR_FILE_ID&export=download");
              desktop.browse(oURL);

        } catch (Exception e) {
            e.printStackTrace();
        }
}