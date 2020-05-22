public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException
{
    final WebClient webClient = new WebClient();

    HtmlPage page = webClient.getPage("http://dv.parliament.bg/DVWeb/broeveList.faces");

    for (HtmlAnchor link : (List<HtmlAnchor>) page.getByXPath("//table[@id='broi_form:dataTable1']//a/img/.."))
    {
        String commandString = link.getOnClickAttribute().replaceAll("return ", "");
        System.out.println(commandString);

        ScriptResult executeJavaScript = page.executeJavaScript(commandString);

        Page newPage = executeJavaScript.getNewPage();
        save(newPage.getWebResponse().getContentAsStream());

        page = webClient.getPage("http://dv.parliament.bg/DVWeb/broeveList.faces");
    }

}