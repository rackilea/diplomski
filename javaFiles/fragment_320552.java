/**
 * Overridden to workaround wicket 7 behavior, which proccessed an error, when ajax navigation is used.
 */
@Override
protected void onComponentTag ( final ComponentTag tag )
{
    super.onComponentTag ( tag );
    if ( !Strings.isEmpty ( tag.getAttribute ( "href" ) ) ) // checking if href is not null or empty with org.apache.wicket.util.string.Strings class.
    {
        tag.put ( "href", "" ); //removing any contents of the href option.
    }
}