Document html = Jsoup.parse(htmlStr);

    for (Element e : html.getElementsByTag("a")) {

        if (!"div".equalsIgnoreCase(e.parentNode().nodeName())) {
            System.out.println(e.attr("href"));
        }

    }