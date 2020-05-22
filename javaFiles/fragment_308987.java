HtmlPage page = (HtmlPage) webClient.getPage("https:website name.com/loginpage");
    HtmlForm form = page.getFormBy("login_form");
        HtmlForm formm= page.getForms().get(0);
    formm.getInputByName("SignInEmailAddress").setValueAttribute("your emailid");
    formm.getInputByName("SignInPassword").setValueAttribute("password");
    page = (HtmlPage) formm.getInputByValue("Login").click();
        System.out.println(page);
        System.out.println(page.asText());