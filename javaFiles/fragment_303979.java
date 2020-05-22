private static final ResourceReference  JS_QM   = new JavaScriptResourceReference( ClientPanel.class, "question.mark.js" );


@Override
public void renderHead( Component component, IHeaderResponse response )
{
    super.renderHead( component, response );
    response.render( JavaScriptReferenceHeaderItem.forReference( JS_QM, "question-mark" ) );
    ...
}