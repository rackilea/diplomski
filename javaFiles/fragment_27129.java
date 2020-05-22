@Override
public void onRequestStart(PortletRequest request, PortletResponse response) {

            final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKey.THEME_DISPLAY);
            final User user = themeDisplay.getUser();

            if (user != null) {
                // will be printed to log/console
                System.out.println("User's language id = " + user.getLanguageId());
            } else {
                System.out.println("Guest user.");
            }

            setUser(user);
}