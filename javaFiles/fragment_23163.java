if(file.exists())
{
    try {
        ArrayList<String> ssids = new ArrayList<>();
        ArrayList<String> psks = new ArrayList<>();
        String data = new String(Files.readAllBytes(file.toPath()));
        Pattern networkPat = Pattern.compile("network=\\{.*?\\}", Pattern.DOTALL);
        Pattern ssidPat = Pattern.compile("ssid=\"(?<ssid>.*?)\"");
        Pattern pskPat = Pattern.compile("psk=\"(?<psk>.*?)\"");
        Matcher netMatch = networkPat.matcher(data);
        while (netMatch.find())
        {
            Matcher ssidMatch = ssidPat.matcher(netMatch.group());
            ssidMatch.find();
            ssids.add(ssidMatch.group("ssid"));
            Matcher pskMatch = pskPat.matcher(netMatch.group());
            psks.add((pskMatch.find()) ? pskMatch.group("psk") : "NONE");
        }
    }
    catch (IOException e) {
       //You'll need to add proper error handling here
    }
}
else
{
    //Do whatever you want here.
}