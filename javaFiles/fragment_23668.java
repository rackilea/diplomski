Document document2 = Jsoup.connect("http://www.meteoam.it/ta/previsione/110/magenta")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").get();
        /* after analyzing HTML of this page I see we can find table by id "oggi" and get all TD cells */
        Elements tableCells = document2.select("div#oggi td");
        /* I see you want to keep the values in an array so I'm creating
           an array of the size matching amount of table cells found */
        String[] values = new String[tableCells.size()];
        int i = 0;
        for (Element td : tableCells) {
            /* putting each cell text into the array */
            values[i++] = td.text();
        }
        /* display collected values */
        System.out.println("TEMP " + values[2]);
        System.out.println("UMIDITÀ " + values[3]);
        System.out.println("VENTO " + values[4]);
        System.out.println("RAFFICHE " + values[5]);