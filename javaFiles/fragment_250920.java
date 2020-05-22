ArrayList<String> downServers = new ArrayList<>();
Element table = doc.select("table").get(0); //select the first table.
Elements rows = table.select("tr");

for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
    Element row = rows.get(i);
    Elements cols = row.select("td");

    if (cols.get(7).text().equals("down")) {
        downServers.add(cols.get(5).text());
    }
}