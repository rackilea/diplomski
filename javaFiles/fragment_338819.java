String url = "http://czat.wp.pl/i,1,chat.html";
Map<String, String> cookies;
String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36";

try {
    Response response = Jsoup.connect(url).userAgent(userAgent).header("Host", "czat.wp.pl").execute();
    URL redirectUrl = response.url();

    cookies = response.cookies();

    String imageUrl = response.parse().select("#secImg > img").attr("abs:src").toString();

    // get captcha image and new cookies 
    System.out.println("Insert captcha code: ");

    response = Jsoup.connect(imageUrl).userAgent(userAgent).cookies(cookies).ignoreContentType(true)
            .header("Referer", redirectUrl.toString()).header("Host", "si.wp.pl")
            .header("Origin", "http://czat.wp.pl").execute();

    byte[] bytes = response.bodyAsBytes();
    BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));

    JFrame frame = new JFrame();
    frame.getContentPane().setLayout(new FlowLayout());
    frame.getContentPane().add(new JLabel(new ImageIcon(image)));
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);

    Scanner scanner = new Scanner(System.in);
    String captcha = scanner.nextLine();

    scanner.close();
    frame.setVisible(false);
    frame.dispose();

    cookies.putAll(response.cookies());

    // login
    String nick = "HalloWorld"; // change

    Document doc = Jsoup.connect(url).userAgent(userAgent).cookies(cookies).data("i", "1").data("auth", "nie")
            .data("nick", nick).data("regulamin", "tak").data("simg", captcha)
            .header("Origin", "http://czat.wp.pl").header("Referer", "http://czat.wp.pl/i,1,chat.html")
            .post();

    if(doc.getElementById("alert") != null){
        System.err.println(doc.getElementById("alert").text());
    }else{
        // do something useful
        System.out.println(doc.text());
    }

} catch (IOException e) {
    e.printStackTrace();
}