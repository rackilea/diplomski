public static void main(String[] args) throws Exception {
    String input = "GET myCommand?parameter1=value1&parameter2=value2&parameter3=value2&parameter4=value4";
    String command = input.replaceAll("(^\\w+ )|(\\?.*)", "");
    Map<String, String> params = new LinkedHashMap<String, String>();
    for (String pair : input.replaceFirst(".*?\\?", "").split("&"))
        params.put(pair.split("=")[0], pair.split("=")[1]);
    System.out.println("Command=" + command);
    System.out.println("Params=" + params);
}