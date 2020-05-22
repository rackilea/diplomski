Elements anchors = document.select(".list_attachments a");

for (Element anchor : anchors) {
     fileName[i] = anchor.text();
     url[i] = anchor.attr("href");
     i++;
}