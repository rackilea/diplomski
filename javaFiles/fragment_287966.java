// Get data
    try {
        final Document document = Jsoup.connect(url).get();
        ArrayList<String> dataArray = new ArrayList<>();
        for (Element row : document.select("table.snapshot-table2 tr")) {

            // continue was unnecessary here, just invert the condition
            if (!row.select("td.snapshot-td2:nth-of-type(10)").text().contentEquals("")) {
                String data = row.select("td.snapshot-td2:nth-of-type(10)").text();
                dataArray.add(data);
            }
        }

        System.out.println(dataArray.get(1));
    } catch (Exception ex) {
        ex.printStackTrace();

    }