Elements links = document.select("#redx_gallery_thumb_list a");

for (Element link : links) {
    String href = link.attr("href");

    // Or if you want to have absolute URL instead, so that you can leech them.
    String absUrl = link.absUrl("href");

    // ...
}