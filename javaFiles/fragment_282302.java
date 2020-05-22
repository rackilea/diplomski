public static ProgressDialog show(Context context, CharSequence title,
        CharSequence message) {
    return show(context, title, message, false);
}

public static ProgressDialog show(Context context, CharSequence title,
        CharSequence message, boolean indeterminate) {
    return show(context, title, message, indeterminate, false, null);
}

public static ProgressDialog show(Context context, CharSequence title,
        CharSequence message, boolean indeterminate, boolean cancelable) {
    return show(context, title, message, indeterminate, cancelable, null);
}

public static ProgressDialog show(Context context, CharSequence title,
        CharSequence message, boolean indeterminate,
        boolean cancelable, OnCancelListener cancelListener) {
    ProgressDialog dialog = new ProgressDialog(context);
    dialog.setTitle(title);
    dialog.setMessage(message);
    dialog.setIndeterminate(indeterminate);
    dialog.setCancelable(cancelable);
    dialog.setOnCancelListener(cancelListener);
    dialog.show();
    return dialog;
}