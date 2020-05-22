@Get
public String foo() {
    Form queryParams = getReference().getQueryAsForm();
    String f = queryParams.getFirstValue("f");
    return f;
}