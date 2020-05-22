String line;
while((line = bufferedReader.readLine()) != null) {
    for(String parts: line.split("\\[")) {
        String[] userProps = parts.split("\\)");
        String users = userProps.length==1 ? "" : userProps[0];
        String props = userProps[userProps.length-1];
        // break up the individual users and props
    }
}