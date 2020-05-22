Document doc = Jsoup.connect(url)
    .data("action", "reply")
    .data("auth", "54a9871a63a1c285879a5327faf3d8d2")
    .data("thread", "135454")
    .data("quickreplytext", replyText)
    .post();