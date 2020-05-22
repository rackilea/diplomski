@ConversationAction(conversations = "form")
@Action(value="formSecondLast", results={@Result(name=SUCCESS, type = "redirect", location="formLast")})
public String formSecondLast() throws Exception {
    //Here goes the code you want it to manipulate the conversation field data.
    //Maybe save to the database or send it to the business tier.
    return SUCCESS;
}

@EndConversation(conversations = "form")
@Action(value="formLast", results={@Result(name=SUCCESS, location="/jsp/form-end.jsp")})
public String formEnd() throws Exception {
    // This is a dummy action that does not do anything.
    // It is called just after formSecondLast ends and sends the user the jsp page.
    return SUCCESS;
}