public void renderHead(IHeaderResponse response) {
    try {
        String locale = datePicker.getLocale().toString();
        String path = "scripts/datepicker/datepicker-" + locale + ".js";

        response.render(JavaScriptHeaderItem.forUrl(path));
    }
    catch (Exception e) {
        // ignored at this moment
    }
}