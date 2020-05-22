// Call it like this:
select(el.getId());

// And the modified select:
public static native void select(String elId)/*-{
    // ...OTHER CODE OMITTED
    range.selectNodeContents($wnd.document.getElementById(elId));
    // ...OTHER CODE OMITTED
}-*/;