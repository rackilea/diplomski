public class WidgetFactory {

    public static final Color BACKGROUND_DEFAULT = new Color(Display.getCurrent(), 224, 231, 255);

public static final String FONT_DEFAULT = "default";

    private static FontRegistry fontRegistry = null;

    static {
    fontRegistry = new FontRegistry(Display.getCurrent());

            putFont(FONT_DEFAULT, "Verdana", fontSizes.get(FONT_DEFAULT), SWT.NONE);
    }

    public static Composite createComposite(Composite parent, int numCols, boolean equalWidth, int gridDataStyle) {
            Composite composite = new Composite(parent, SWT.NONE);
            composite.setFont(fontRegistry.get(FONT_DEFAULT));
            composite.setBackground(BACKGROUND_DEFAULT);

            GridData gridData = new GridData(gridDataStyle);
            composite.setLayoutData(gridData);

            GridLayout layout = new GridLayout(numCols, equalWidth);
            layout.marginWidth = 0;
            layout.marginHeight = 0;
            layout.horizontalSpacing = 0;
            layout.verticalSpacing = 0;
            composite.setLayout(layout);

            return composite;
        }

        public static Label createLabel(Composite parent, String text, String toolTipText) {
            Label theLabel = new Label(parent, SWT.NONE);
            theLabel.setText(trim(text));
            theLabel.setToolTipText(trim(toolTipText));
            theLabel.setFont(fontRegistry.get(FONT_DEFAULT));
            parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
            return theLabel;
        }
    }