Elements headings = doc.select("td[class=whiteheading]");
        Elements data = doc.select("td[class=copyrights]");

        for (Element el : headings) {
            System.out.print(el.text() + "\t\t\t");
        }

        System.out.println();
        for (Element el : data) {
            System.out.print(el.text() + "\t");
        }