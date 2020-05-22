/**
 *  @return true if keyEvent is consumed
 */
public static boolean onKeyDown(final Activity activity, final Class<?> action, String message, int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

        //...all you code here

        return true;
    }
    return false;
}