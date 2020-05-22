public void getSearchResult(final String searchString){

        /*--The connection to the server is established in another (not main) thread.
        This prevents the app to stop responding if the connection to the server is not established
        or it takes time to establish the connection--*/

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //Send search string to the server
                    URL mobileurl = new URL("http://10.0.2.2:8080/project_server/Search");
                    URLConnection connection = mobileurl.openConnection();
                    connection.setDoOutput(true);

                    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
                    out.write(searchString);
                    out.close();

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    in.readLine();
                    in.close();

                    //Fetch result in XML format
                    URL GetCardXmlUrl = new URL("http://10.0.2.2:8080/searchresultxml/search_xml_output.xml");
                    URLConnection GetresultXmlConnection = GetCardXmlUrl.openConnection();
                    InputStream ResultInstream = new BufferedInputStream(GetresultXmlConnection.getInputStream());
                    Serializer PhoneBookSerializer = new Persister();

                    Search_info_xml parse_result_xml = PhoneBookSerializer.read(Search_info_xml.class, ResultInstream);

                    final String[] data = parse_result_xml.getPhones();

                    runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                            setListAdapter(new ArrayAdapter<String>(SearchResult.this, R.layout.phonebook_listview, data));
                        }
                    });

                    Log.d("note:", "getting stuff");
                    Log.d("number: ", mobile_nos[0]);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

}