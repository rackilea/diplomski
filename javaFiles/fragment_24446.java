Document doc = Jsoup.connect(url)
        .header("Accept-Language", "en")
        .header("Authorization", "Basic " + clientCred)
        .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
        .data(data)
        .ignoreHttpErrors(true)
        .ignoreContentType(true)
        .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9"+ ",*/*;q=0.8")
        .post();