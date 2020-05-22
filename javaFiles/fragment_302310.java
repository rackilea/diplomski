List<HashMap> list = new ArrayList<>();
HashMap<String, String> hmap;
String raw = "<CONTENT><DETAIL><USER>user1</USER><MAIL>abc@test.com</MAIL></DETAIL><DETAIL><USER>user2</USER><MAIL>def@test.com</MAIL></DETAIL></CONTENT>";
String partRas = "";
int index = raw.indexof("<USER>");

while(index >= 0) {
    if(index + 50 < raw.length())
        partRaw = raw.subString(index, index + 50);

    /*
     * Create a new, empty HashMap 
     */
    hmap = new HashMap<>();
    hmap("user", getTagValue(partRaw, "USER"));
    hmap("email", getTagValue(partRaw, "MAIL"));
    list.add(hmap);

    raw = raw.subString(index + 50, raw.length());
    index = raw.indexof("<USER>");
}

System.out.println(new Gson().toJson(list));

public static String getTagValue(String xml, String tagName){
    return xml.split("<"+tagName+">")[1].split("</"+tagName+">")[0];
}