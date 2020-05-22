public static void main(String[] args) {
    String in = "\"xmlImageIds\":\"57948916||57948917||57948918||57948919||57948920||57948921||57948‌922||57948923||57948924||57948925||57948926||5794892\"".replace("||", "|");

    String[] q = in.split("\"");
    String[] ids = q[3].split("\\|");
    for (String id : ids) {
        System.out.println("http://test/" + id);
    }
}