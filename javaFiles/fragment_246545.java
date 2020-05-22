Document doc = Jsoup.parse(input1);
/* Grab all elements named "scan_run_sttus" */
Elements els = doc.select("scan_run_status");
/* If you need the first only ...here it is..*/
String status = els.first().text();
/* Otherwise you can loop 
for (Element el: els) {
   //.Do something
}
*/