try {
    String value = URLEncoder.encode("NÃO", "utf-8");
    String url = "://www.mydomain.com/?param1=" + value + "&param2="
            + value;
    System.out.println(url);
} catch (UnsupportedEncodingException e) {
    e.printStackTrace();
}