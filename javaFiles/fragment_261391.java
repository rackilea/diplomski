Document document = Jsoup.parse(html);

Elements elements =
            document.select("div.video script.video_preview_source");

Document iframeDoc = Jsoup.parse(elements.get(0).data());

Elements iframeElements = iframeDoc.select("iframe");

System.out.println(iframeElements.attr("src"));