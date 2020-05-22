Elements row = doc.select("td.css-sched-waypoints");
    Element title = doc.select("td.css-sched-table-title").first();

    System.out.println(title.text());
    Iterator<Element> iterator = row.listIterator();
    while (iterator.hasNext()) {
        Element element = iterator.next();
        String id = element.attr("id");
        String classes = element.attr("class");
        String value = element.text();
        System.out.println("Id : " + id + ", classes : " + classes
                + ", value : " + value);
    }