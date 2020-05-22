Document doc = Jsoup.connect(
                "https://supportforums.cisco.com/t5/lan-switching-and-routing/bd-p/6016-discussions-lan-switching-routing")
                .get();
        for (Element e : doc.select("#grid tr.lia-list-row-thread-solved")) {
            String text = e.text();
            System.out.println(text);
        }