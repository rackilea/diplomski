private static Activity unwrap(Context context) {
    while (!(context instanceof Activity) && context instanceof ContextWrapper) {
        context = ((ContextWrapper) context).getBaseContext();
    }

    return (Activity) context;
}