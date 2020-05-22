Elements elements = doc.select("table[class=display fpltable]");

    Elements rows = elements.get(0).select("tr");

    for (Element row : rows) {

        if (row.select("td").size() == 8) {
            String iPAddress = row.select("td").get(0).text();
            String port = row.select("td").get(1).text();
            String code = row.select("td").get(2).text();
            String country = row.select("td").get(3).text();
            String anonymity = row.select("td").get(4).text();
            String google = row.select("td").get(5).text();
            String https = row.select("td").get(6).text();
            String lastChecked = row.select("td").get(7).text();
        }

    }