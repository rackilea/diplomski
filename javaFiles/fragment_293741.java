Document doc = Jsoup.connect("http://www.nasdaqomxbaltic.com/market/?pg=charts&lang=en&idx_main%5B%5D=OMXBBGI&add_index=OMXBBPI&add_equity=LT0000128266&period=6months&start_d=19&start_m=7&start_y=2011&end_d=19&end_m=1&end_y=2012").get();
Elements csvLinkFiles= doc.select("div.download > a");
int filesCounter = 0;
for (Element link : csvLinkFiles) {
    String href = link.attr("href");
    URL csvFileLink= new URL(href);
    ReadableByteChannel rbc = Channels.newChannel(csvFileLink.openStream());
    FileOutputStream fos = new FileOutputStream("csv-file-"+ (++filesCounter) + ".csv");
    fos.getChannel().transferFrom(rbc, 0, 1 << 24);
}