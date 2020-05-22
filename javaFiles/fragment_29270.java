try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {

        // disable caching
        webClient.getCache().setMaxSize(0);

        // Get the first page
        final HtmlPage page1 = webClient.getPage(url);

        final HtmlForm form = page1.getFormByName(formName);

        final HtmlTextInput taxCodeTextField = form.getInputByName(taxCodeTextFieldName);
        HtmlCheckBoxInput checkboxInput = form.getInputByName(checkboxInputName);

        taxCodeTextField.type(taxCode);
        checkboxInput.click();

        //wait a little
        Thread.sleep(2000);

        //get the main page
        HtmlPage page2 = (HtmlPage) webClient.getTopLevelWindows().get(0).getEnclosedPage();

        HtmlSubmitInput confirmButton = page2.getFormByName(formName).getInputByName(confirmButtonName);

        final HtmlPage page3 = confirmButton.click();

        System.out.println(page3.asText());
    }