public void renderHead( IHeaderResponse response )
{
    String jQueryString = "";
    if ( u != null )
    {
        jQueryString += "jQuery('#openPopup').trigger('click');";
    }
    response.renderOnLoadJavaScript( jQueryString );
}