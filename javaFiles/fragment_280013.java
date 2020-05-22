@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    // create ContextThemeWrapper from the original Activity Context with the custom theme
    final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.yourCustomTheme);

    // clone the inflater using the ContextThemeWrapper
    LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

    // inflate the layout using the cloned inflater, not default inflater
    return localInflater.inflate(R.layout.yourLayout, container, false);
}