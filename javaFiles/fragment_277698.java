Elements ol = doc.select("ol.work > li");

for (Element li : ol) {
    String title = li.select("h4.heading a").first().text();
    String author = li.select("h4.heading a[rel=author]").text();
    String id = li.attr("id").replaceAll("work_","");
    String url = "http://archiveofourown.com/works/" + id;
    String summary = li.select("blockquote.summary").text();
    String rating = li.select("span.rating").text();

    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("ID: " + id);
    System.out.println("URL: " + url);
    System.out.println("Summary: " + summary);
    System.out.println("Rating: " + rating);
}