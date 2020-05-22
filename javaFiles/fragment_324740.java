public void getItembyID(String code) {
    String site;

    site = "http://www.sprii.net/db/getItem.php?pid=" + code + "/";

    try {
        URL url = new URL(site);
    } catch (MalformedURLException e) {
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }

}