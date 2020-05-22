String resourceKey = "DYN_RES_KEY";
//load your text template
final TextTemplate textTemplate = new PackagedTextTemplate(MyPage.class, "script.js", "text/javascript", "UTF-8");
//add the resource
getSharedResources().add(resourceKey, new Resource() {
    @Override
    public IResourceStream getResourceStream() {
        String queryParam = getParameters().getString("paramName");
        //...do whatever you need with the parameters...
        Map<String,Object> vars = new HashMap<String,Object>();
        vars.put("param", queryParam);
        String stringValue = textTemplate.asString(vars);
        return new StringResourceStream(stringValue, textTemplate.getContentType());
    }
});
//mount the resource at some public URL
mountSharedResource("/resource", Application.class.getName() + "/" + resourceKey);
//make alias, optional
getSharedResources().putClassAlias(MyPage.class, "scripts");