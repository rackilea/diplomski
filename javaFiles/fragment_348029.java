public static String getDateWithinHtmlInsideZipFile(File archive) {
      ZipFile zp = new ZipFile(archive);
      InputStream in = zp.getInputStream (zp.getEntry ("Index.htm"));

      Document doc = Jsoup.parse(in, "UTF-8", "");

    return doc.body().getElementsByClass("Datum").text().trim();
}