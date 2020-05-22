public class CustomLocaleFxResourceBundleControlProvider implements ResourceBundleControlProvider {
    private static final ResourceBundle.Control MY_RESOURCE_BUNDLE_CONTROL = new CustomLocaleFxResourceBundleControl();

    public ResourceBundle.Control getControl(String baseName) {
        if (CustomLocaleFxResourceBundleControl.FX_BASE_NAME.equals(baseName))
            return MY_RESOURCE_BUNDLE_CONTROL;

        return null;
    }
}