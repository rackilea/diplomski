webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
    @Override
    public void commandReceived(WebBrowserCommandEvent e) {
        // Check if you have the right command here, left out for the example
        // Parse the paramaters into a Hashtable or something, also left out for the example
        int sum = 0;
        for( String number : arguments.get( "numbers" ).split( "," ) ){
            sum += Integer.parseInt( number );
        }

        // Execute the javascript callback like would happen with a regular JSONP call.
        webBrowser.executeJavascript( arguments.get( "callback" ) + "({ result: " + sum + " });" );
    }
});