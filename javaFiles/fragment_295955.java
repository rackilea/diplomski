//set browser
WebClient webClient = new WebClient(BrowserVersion.FIREFOX_10); 
//not to throw exception on javascript error
webClient.setThrowExceptionOnScriptError(false);
//set page to access
final HtmlPage homepageEn = webClient.getPage("http://protein.rnet.missouri.edu:8080/MongoTest/");
//get the form by id
HtmlForm form = homepageEn.getFirstByXPath("//form[@id='input_form']"); 
//setup the fields to use 
HtmlTextInput mailField = form.getInputByName("mail");
HtmlPasswordInput passwordField = form.getInputByName("password");
//define the submit button (defined by value)
HtmlSubmitInput submitButton = form.getInputByValue("submit");
//change the value of text fields
mailField.setValueAttribute("somemail@xyzmail.com");
passwordField.setValueAttribute("some_password");
//finally submit the form by clicking the button
final HtmlPage resultsPage = submitButton.click();