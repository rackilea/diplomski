public class AjaxJsfView extends JsfView {
private Logger logger = Logger.getLogger(AjaxJsfView.class);

private String prefix;

private String suffix;

private String viewName;

@Override
protected void renderMergedOutputModel(Map map, HttpServletRequest request, HttpServletResponse response) throws Exception {
    logger.debug("renderMergedOutputModel - enter");
    logger.debug("renderMergedOutputModel - map : " + map);
    logger.debug("renderMergedOutputModel - request : " + request);
    logger.debug("renderMergedOutputModel - response : " + response);

    viewName = (String)map.get("view");

    super.renderMergedOutputModel(map, request, response);

    logger.debug("renderMergedOutputModel - response : " + response);
    logger.debug("renderMergedOutputModel - exit");
}

public String getPrefix() {
    return prefix;
}

public void setPrefix(String prefix) {
    this.prefix = prefix;
}

public String getSuffix() {
    return suffix;
}

public void setSuffix(String suffix) {
    this.suffix = suffix;
}

@Override
public String getUrl() {
    return getPrefix() + viewName + getSuffix();
}

@Override
public void setUrl(String arg0) {
    super.setUrl(arg0);
}
}