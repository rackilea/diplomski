Dimension pref = null;

void getNewPrefOnlyWhenNeeded() {
    pref = component.getPreferredSize();
}

void calledEveryMillisecond() {
    //Here or on the Constructor, MouseListener or wherever
    if (pref == null || someCondition) getNewPrefOnlyWhenNeeded();

    // do stuff with pref...
    ...

    //setPreferredSize can actually be skipped if we call our layout manager after all is resized. It would be dirty tho...   
    component.setPreferredSize(pref);
}