String[] supported = server.getSupportedCipherSuites();
List<String> list= new ArrayList<String>();

for(int i = 0; i < supported.length; i++)
{
    if(supported[i].indexOf("_anon_") > 0)
    {
        list.add(supported[i]);
    }
}
String[] anonCipherSuitesSupported = list.toArray(new String[0]);