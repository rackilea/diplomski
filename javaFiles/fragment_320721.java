Map<String, String> options = new LinkedHashMap<String, String>();
Document document = Jsoup.connect("http://other.com/some.html").get();

for (Element option : document.select("select[name=CATEGORY_ID] options")) {
    options.put(option.attr("value"), option.text());
}

request.setAttribute("options", options);
request.getRequestDispatcher("/WEB-INF/some.jsp").forward(request, response);