/**
 * Sets the page class and its parameters that will respond to this request
 * 
 * @param <C>
 * 
 * @param cls
 *            The response page class
 * @param parameters
 *            The parameters for this bookmarkable page.
 * @see RequestCycle#setResponsePage(Class, PageParameters)
 */
public final <C extends Page> void setResponsePage(final Class<C> cls, PageParameters parameters)
{
    getRequestCycle().setResponsePage(cls, parameters);
}