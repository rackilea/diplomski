public static void setLanguage(Context context, String language) {
            String[] localeLang = language.split("_");
            Locale locale;
            if (localeLang.length > 1)
                locale = new Locale(localeLang[0], localeLang[1]);
            else
                locale = new Locale(localeLang[0]);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                config.setLayoutDirection(locale);
                ((Activity) context).getWindow().getDecorView().setLayoutDirection(config.getLayoutDirection());
            }
            context.getResources().updateConfiguration(config,
                    context.getResources().getDisplayMetrics());
        }