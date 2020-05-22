@Override
protected void showDialog(Bundle state) {
    super.showDialog(state);
    Typeface customFont = FontCache.getTypeface("UnderwoodChampionRegular.ttf", GameActivity.commandReceiver.activity_settings);

    final Resources res = getContext().getResources();
    final Window window = getDialog().getWindow();

    // Title
    final int titleId = res.getIdentifier("alertTitle", "id", "android");
    final View title = window.findViewById(titleId);
    if (title != null) {
        ((TextView) title).setTextColor(ContextCompat.getColor(MyCommandReceiver.context_settings, R.color.THEME_LIGHT_TEXT));
        ((TextView) title).setTypeface(customFont);
    }

    // Title divider
    final int titleDividerId = res.getIdentifier("titleDivider", "id", "android");
    final View titleDivider = window.findViewById(titleDividerId);
    if (titleDivider != null) {
        titleDivider.setBackgroundColor(ContextCompat.getColor(MyCommandReceiver.context_settings, R.color.THEME_LIGHT_TEXT));
    }

    // EditText
    final View editText = window.findViewById(android.R.id.edit);
    if (editText != null) {
        ((EditText) editText).setTextColor(ContextCompat.getColor(MyCommandReceiver.context_settings, R.color.THEME_LIGHT_TEXT));
        ((EditText) editText).setTypeface(customFont);
    }

    //OK button
    final View okButton = window.findViewById(android.R.id.button1);
    if (okButton != null) {
        ((Button) okButton).setTextColor(ContextCompat.getColor(MyCommandReceiver.context_settings, R.color.THEME_LIGHT_TEXT));
        ((Button) okButton).setTypeface(customFont);
    }

    //Cancel button
    final View cancelButton = window.findViewById(android.R.id.button2);
    if (cancelButton != null) {
        ((Button) cancelButton).setTextColor(ContextCompat.getColor(MyCommandReceiver.context_settings, R.color.THEME_LIGHT_TEXT));
        ((Button) cancelButton).setTypeface(customFont);
    }
}