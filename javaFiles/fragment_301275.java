String acontent = "<head>Some head</head><body><div>A div</div><div><img src=\"/base/img/avs.jpg\"/></div><div>Another div</div></body>";
    Document document = Jsoup.parse(acontent);
    System.out.println(document);
    //select element you want to change
    Element img = document.select("img").first();
    //wrap it with p
    Element p = new Element("p");
    p.html(img.outerHtml());
    //append br
    Element br = new Element("br");
    p.appendChild(br);
    //replace original with new
    img.replaceWith(p);

    System.out.println(document);