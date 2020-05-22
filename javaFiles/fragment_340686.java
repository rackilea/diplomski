private Component gridComponent;

public JqTable(final String id){
    super(id);
    gridComponent = new WebMarkupContainer("grid").setOutputMarkupId(true);
    add(gridComponent);
}

@Override
public void renderHead(final IHeaderResponse response){
    final String options = "{json}"; // code stripped so I don't need to
                                     // include json in my classpath

    final String contextPath = "context"; // dito with servlet api

    response.renderJavascriptReference(contextPath
        + "/js/jquery.jqGrid.min.js");
    response.renderJavascript("$(document).ready(function() { options = "
        + options + ";$('#" + gridComponent.getMarkupId()
        + "').jqGrid(options); });", gridComponent.getMarkupId());

    // btw wicket has it's own domready mechanism, so you could also write it like this:
    response.renderOnDomReadyJavascript("options = "
        + options + ";$('#" + gridComponent.getMarkupId()
        + "').jqGrid(options);");
}