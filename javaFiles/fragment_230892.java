public static void setNimbusUI(final IMethod<UIDefaults> method)
    throws UnsupportedLookAndFeelException {

    try {
        // NimbusLookAndFeel may be now available
        UIManager.setLookAndFeel(new NimbusLookAndFeel() {

            @Override
            public UIDefaults getDefaults() {
                final UIDefaults defaults = super.getDefaults();
                method.perform(defaults);
                return defaults;
            }

        });
   } catch (NoClassDefFoundError e) {
       throw new UnsupportedLookAndFeelException(e);
   }
}