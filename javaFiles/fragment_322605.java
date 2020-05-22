for (Element tr : doc.select("#closings tr")) {
    System.out.println("----------------------");
    for (Element td : tr.select("td")) {
        System.out.println(td.text());
    }
}