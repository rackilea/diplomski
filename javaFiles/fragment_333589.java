public void getData(HashMap<String, String> formFields) throws Exception{
         Connection conn = Jsoup.connect("https://academicscc.vit.ac.in/student/stud_login_submit.asp")
        .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
        .cookies(cookies)
        .timeout(0)
        .data(formFields)
        .method(Connection.Method.POST);}