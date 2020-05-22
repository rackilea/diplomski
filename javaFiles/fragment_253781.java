public class SO_28619161 {


    public Map cookies;
    private String username = "u";
    private String password = "p";

    public HashMap<String,String> downloadCaptcha()throws Exception {
        Connection.Response response = Jsoup.connect("https://academics.ddn.upes.ac.in/upes/")
                .timeout(300000)
                .userAgent("Mozilla/5.0")
                .method(Connection.Method.GET).execute();

        //nice
        cookies = response.cookies();

        //now we will load form's inputs 
        Document doc = response.parse();
        Elements fields = doc.select("form input");
        HashMap<String,String> formFields = new HashMap<String, String>();
        for (Element field : fields ){
            formFields.put(field.attr("name"), field.attr("value"));
        }

        Connection.Response resultImageResponse = Jsoup.connect("https://academics.ddn.upes.ac.in/upes/modules/create_image.php")
                .cookies(cookies)
                .ignoreContentType(true)
                .method(Connection.Method.GET).timeout(30000).execute();

        //we will need these cookies also!
        cookies.putAll(resultImageResponse.cookies());

        FileOutputStream out = (new FileOutputStream(new java.io.File("abc.jpg")));
        out.write(resultImageResponse.bodyAsBytes()); 
        out.close();

        System.out.println("Captcha Fetched");

        return formFields;
    }

    public void getData(HashMap<String, String> formFields) throws Exception{
        Connection conn = Jsoup.connect("https://academics.ddn.upes.ac.in/upes/index.php")
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0")
                //not neccesary but these extra headers won't hurt
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "es-ES,es;q=0.8,en-US;q=0.5,en;q=0.3")
                .header("Host", "academics.ddn.upes.ac.in")
                .header("Referer", "https://academics.ddn.upes.ac.in/upes/index.php")
                .cookies(cookies)
                .timeout(0)
                .method(Connection.Method.POST);

        //we send the fields
        conn.data(formFields);

        Response response = conn.execute();
        cookies = response.cookies();
        System.out.println(response.cookies());
        Document doc= response.parse();
        FileWriter fr = new FileWriter("response.html");
        PrintWriter pw= new PrintWriter(fr);
        pw.println(doc.toString());
        System.out.println(doc.toString());
        pw.close();
        fr.close();
    }

    private void run() throws Exception, IOException {
        HashMap<String, String> formFields = downloadCaptcha();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String captcha = br.readLine();

        //we set user/pass and captcha
        formFields.put("username", username);
        formFields.put("passwd", password);
        formFields.put("txtCaptcha", captcha);

        getData(formFields);
    }

    public static void main(String[] args) throws Exception {
        SO_28619161 main = new SO_28619161();
        main.run();
    }

}