ViewConfiguration configure = ViewConfiguration.get(context);
Field menuField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
if (menuField != null) {
    menuField.setAccessible(true);
    menuField.setBoolean(config, false);
}