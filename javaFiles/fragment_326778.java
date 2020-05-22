/**
 * Designer mode. This is used to detect if the widgets are running
 * from SWT designer, because in this case we have to skip some
 * initialization code.
 */
private static Boolean designerMode;

/**
 * This is used to detect if the widgets are running
 * from SWT designer, because in this case we have to skip some
 * initialization code.
 */
public static boolean isDesignerMode() {
    if( designerMode == null ) {
        String s = StacktraceUtils.getStackTraceAsString(
                new RuntimeException("Just to get the Stacktrace."));
        designerMode = s.contains("com.instantiations.designer");  
    }
    return designerMode;
}