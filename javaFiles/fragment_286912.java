Elements trs = doc.select("table.table_stato_dati").select("tr:has(td)");
        for (Element tr : trs) {
            Elements tds = tr.select("td");
            for (Element td : tds) {
                System.out.print(td.text()+" ");                
            }
            System.out.println();
        }