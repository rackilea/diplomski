public static void main(String[] args) throws IOException, SAXException, TikaException, SQLException, ParseException, URISyntaxException {      


        Preferences userPrefs = Preferences.userNodeForPackage(TBB_SQLBuilder.class);

        String[] keys = userPrefs.keys();

        for(int i=0; i<keys.length; i++){

           String value = userPrefs.get(key, "No value for this key");

        }

}