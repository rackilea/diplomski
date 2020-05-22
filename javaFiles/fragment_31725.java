try {
    FileInputStream VOD = new FileInputStream("channels.txt");
    BufferedReader buffer_r = new BufferedReader(new InputStreamReader(VOD));
    String line;
    ArrayList<String> name_channels = new ArrayList<String>();

    while((line = buffer_r.readLine()) != null ){
        if(line.startsWith("#")){
            String regex = "tvg-name=\"([^\"]+)\"";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                name_channels.add(matcher.group(1));
            }
        } else {
            // ...
        }
    }
    for(int i = 0; i < name_channels.size(); i++){
        System.out.println("Channel: " + name_channels.get(i));
    }
}catch(Exception e){
    System.out.println(e);
}