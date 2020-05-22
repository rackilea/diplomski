public class BaseForm extends WhateverYouHave {
    public STKUser getUser(HttpServletRequest request) {
        return request.getSession().getAttribute("STKUserSession");
    }
    ...
}

...

public class AnotherServlet extends BaseForm {
    public TD0301Assignment updateAssignment(HttpServletRequest request) {
        if (getUser(request).equals(tdas.getOriginator())) {
        ...