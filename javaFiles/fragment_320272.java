final HtmlForm form = page.getFormByName("j_id2");
final HtmlTextInput textField = form.getInputByName("j_id2:j_id4");
final HtmlTextInput textField1 = form.getInputByName("j_id2:j_id6");

final HtmlSubmitInput button = form.getInputByName("j_id2:j_id5");
for (String s : list) {
    textField.setValueAttribute(String.valueOf(week));
    textField1.setValueAttribute(s);
    button.click();
}