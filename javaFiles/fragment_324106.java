public static void main(String[] args) throws IOException {
    Document doc = Jsoup.connect("http://www.wsj.com/mdc/public/page/2_3021-gainnyse-gainer.html").get();
    Elements rows = doc.select("tr");

    Map<Integer, HashMap<String, String>> top5 = new HashMap<>(5);

    int arrayFill = 0;
    for (int i = 0; i < rows.size(); i++) {
        Elements columns = rows.get(i).select("td");
        String[][] trtd = new String[columns.size()][];
        for (Element column : columns) {
            System.out.println(column.text());
        }
        System.out.println();
        if (i > 2 &&i <8&& columns.size() > 4) {
            HashMap<String, String> map = new HashMap<>(1);
            map.put(columns.get(1).text(), columns.get(4).text());
            top5.put(Integer.parseInt(columns.get(0).text()), map);
        }

    }
    System.out.println("using keySet");
    for (Integer key : top5.keySet()) {
        System.out.println(key + "=" + top5.get(key));
    }


}