@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public static String getUserAgent(final Context context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        return WebSettings.getDefaultUserAgent(context);
    }
    else {
        try {
            final Class<?> webSettingsClassicClass = Class.forName("android.webkit.WebSettingsClassic");
            final Constructor<?> constructor = webSettingsClassicClass.getDeclaredConstructor(Context.class, Class.forName("android.webkit.WebViewClassic"));
            constructor.setAccessible(true);
            final Method method = webSettingsClassicClass.getMethod("getUserAgentString");
            return (String) method.invoke(constructor.newInstance(context, null));
        }
        catch (final Exception e) {
            return new WebView(context).getSettings()
                    .getUserAgentString();
        }
    }
}