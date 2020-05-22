public static void apply(Spinner spinner) {
    try {
        Field listPopupField = Spinner.class.getDeclaredField("mPopup");
        listPopupField.setAccessible(true);
        Object listPopup = listPopupField.get(spinner);
        if (listPopup instanceof ListPopupWindow) {
            Field popupField = ListPopupWindow.class.getDeclaredField("mPopup");
            popupField.setAccessible(true);
            Object popup = popupField.get((ListPopupWindow) listPopup);
            if (popup instanceof PopupWindow) {
                ((PopupWindow) popup).setFocusable(false);
            }
        }
    } catch (NoSuchFieldException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
}