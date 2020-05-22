public class FormSubmit {

    public static void main(String[] args) throws Exception {
        try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
            final HtmlPage page1 = webClient.getPage("https://applicazioni.gse.it/GWA_UI/");

            System.out.println(page1.asXml());
            final HtmlForm form = page1.getFormByName("aspnetForm");

            final HtmlTextInput username = form.getInputByName("ctl00$ctl00$cphFormAppl$cphRisultatiRicerca$txtUserid");

            username.setValueAttribute("namevalue");         

            final HtmlPasswordInput password = form.getInputByName("ctl00$ctl00$cphFormAppl$cphRisultatiRicerca$txtPassword");
            password.setValueAttribute("passvalue");

            final HtmlPage page2 = (HtmlPage) form.getInputByValue(" Login ").click();
            System.out.println(page2.asText());
        }
    }
}