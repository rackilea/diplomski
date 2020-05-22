if (themeName != null && !themeName.equals(this.currThemeName)) {
            try {
                if (themeName.equals(DEFAULT_THEME_NAME)) {
                    defaultTheme = Resources.open(DEFAULT_THEME_NAME);
                    bundle = null;
                } else {
                    defaultTheme = Resources.open(DEFAULT_THEME_NAME);
                    bundle = Resources.open(themeName);
                }
               mergeL10N = defaultTheme.getL10N("Localization (L10N) 1", "iw");
                if (bundle != null) {
                  mergeHashtable(mergeL10N, bundle.getL10N("Localization (L10N) 1", "iw"));
                 }
                  UIManager.getInstance().setResourceBundle(mergeL10N);

                                      }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }