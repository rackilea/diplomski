XmlRpcClient client = new XmlRpcClient()
client.setTransportFactory(new XmlRpcTransportFactory(){

        @Override
        public XmlRpcTransport getTransport() {

            return new XmlRpcSunHttpTransport(client){
                protected java.net.URLConnection getURLConnection(){
                    URLConnection urlConnection = super.getURLConnection();
                    urlConnection.setConnectTimeout(60000);
                    urlConnection.setReadTimeout(60000);
                    return urlConnection;
                }
            };

        }});