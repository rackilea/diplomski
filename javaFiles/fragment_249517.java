try (WebClient webClient = new WebClient(BrowserVersion.FIREFOX_52))
{
    webClient.getOptions().setUseInsecureSSL(true);

    HtmlPage page = webClient.getPage(url);
    String pageContent = page.asText();
    System.out.println(pageContent);

    HtmlButtonInput button = page.getFirstByXPath("//input[@type = 'button']");
    // to make sure you got the right element
    System.out.println(button.asXml());

    HtmlTextInput name  = (HtmlTextInput) page.getElementById("username"); 
    HtmlPasswordInput pwd  = (HtmlPasswordInput) page.getElementById("password");

    // use type() to simulate typing
    name.type(username);
    pwd.type(password);

    // no need to get the page here because this is still the one the
    // button is placed on
    button.click();

    // wait for ajax to do the job
    webClient.waitForBackgroundJavaScript(10000);


    // ok hopefully the job is done and the login was successfull
    // lets get the current page out of the current window
    HtmlPage loggedInPage = (HtmlPage) page.getEnclosingWindow().getTopWindow().getEnclosedPage();

    ...

    // check the result
    // you can also write this to a file and open it in a real browser
    // maybe the login was failing and there is an error message
    // rendered on this page
    System.out.println(loggedInPage.asXml());

}