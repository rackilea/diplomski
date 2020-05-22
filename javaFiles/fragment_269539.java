doc = Jsoup.connect(tempUrl)
  .data("fromDate", "17/06/2015")
  .data("toDate", "17/06/2016")
  .data("type", "101")
  .data("search", "search")
  .timeout(10000)
  .post();