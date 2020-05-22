Elements thumbs = jsDoc2.select("div.latest-media-images img.latestMediaThumb");

int index = 0;

for(Element thumb : thumbs) {
    Log.e("URL" + index, (thumb.attr("src"));
    index++;
}