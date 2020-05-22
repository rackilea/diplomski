Collection<? extends StatusLineElementProvider> all = 
    Lookup.getDefault().lookupAll(StatusLineElementProvider.class);
for (StatusLineElementProvider a : all) {
    if (a instanceof StatusBar) {
        StatusBarJPanel ele = (StatusBarJPanel ) ((StatusBar) a).getStatusLineElement();
        ele.doUpdate(); // or whatever method you need to call
    }
}