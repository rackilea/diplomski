public static final HashMap<String, String> acceptTypes = new HashMap<String, String>(){{
        put("html", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        put("img", "image/png,image/*;q=0.8,*/*;q=0.5");
        put("script", "*/*");
        put("style", "text/css,*/*;q=0.1");
    }};

protected void downloadCssAndImages(HtmlPage page) {
        String xPathExpression = "//*[name() = 'img' or name() = 'link' and @type = 'text/css']";
        List<?> resultList = page.getByXPath(xPathExpression);

        Iterator<?> i = resultList.iterator();
        while (i.hasNext()) {
            try {
                HtmlElement el = (HtmlElement) i.next();

                String path = el.getAttribute("src").equals("")?el.getAttribute("href"):el.getAttribute("src");
                if (path == null || path.equals("")) continue;

                URL url = page.getFullyQualifiedUrl(path);

                WebRequestSettings wrs = new WebRequestSettings(url);
                wrs.setAdditionalHeader("Referer", page.getWebResponse().getRequestSettings().getUrl().toString());

                client.addRequestHeader("Accept", acceptTypes.get(el.getTagName().toLowerCase()));
                client.getPage(wrs);
            } catch (Exception e) {}
        }



client.removeRequestHeader("Accept");
}