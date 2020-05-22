byte[] bytes = Jsoup.connect(linkUrl)
.header("Accept-Encoding", "gzip, deflate")
.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0")
.referrer(URL_TO_PARSE)
.ignoreContentType(true)
.maxBodySize(0)
.timeout(600000)
.execute()
.bodyAsBytes();