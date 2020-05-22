/**
 * This is how the framework determines which interfaces we implement.
*/
@SuppressWarnings("rawtypes")
@Override
public Object getAdapter(Class key) {
    if (key.equals(IContentOutlinePage.class)) {
        return showOutlineView() ? getContentOutlinePage() : null;
    } else {
        return super.getAdapter(key);
    }
}

/**
 * This accesses a cached version of the content outliner.
 */
public IContentOutlinePage getContentOutlinePage() {
    if (contentOutlinePage == null) {
        //your outlinepage from your editor
        //or create a custom page(s)
    }
    return contentOutlinePage;
}

/**
 * Returns whether the outline view should be presented to the user.
 */
protected boolean showOutlineView() {
    //e.g if StructuredTextEditor xmlEditor;
    //like this we force the editor getAdapter contentOutline part
    //to return false, and therefore the contentoutline will get a value of
    //null that results in "an outline in not available" in the outline view
    if(getActiveEditor() != xmlEditor)) {
        return false;
    }
    return true;
}