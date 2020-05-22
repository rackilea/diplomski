public Main() throws Exception {
    WebClient webClient = new WebClient();
    webClient.setJavaScriptEnabled(false);
    HtmlPage page = webClient.getPage("http://www.chapitre.com");
    List<HtmlImage> imageList = (List<HtmlImage>) page.getByXPath("//img");
    for (HtmlImage image : imageList) {
        try {
            new URL(image.getSrcAttribute());
            if (image.getHeightAttribute().equals("1") && image.getWidthAttribute().equals("1")) {
                System.out.println(image.getSrcAttribute());
            }
        } catch (Exception e) {
            System.out.println("You didn't see this comming :)");
        }
    }
}