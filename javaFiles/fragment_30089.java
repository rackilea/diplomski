public static void main(String... args) throws Exception {
    final WebClient webClient = new WebClient();
    final HtmlPage page1 = webClient.getPage("http://some_url");
    final HtmlForm form = page1.getFormByName("myform");

    final HtmlSubmitInput button = form.getInputByName("submitbutton");
    final HtmlTextInput textField = form.getInputByName("userid");

    textField.setValueAttribute("root");

    final HtmlPage page2 = button.click();

    webClient.closeAllWindows();
}