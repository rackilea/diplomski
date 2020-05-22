@SuppressWarnings("restriction")
public class MyRenderer extends BooleanControlSWTRenderer {

    @Override
    protected Control createSWTControl(final Composite parent, Setting setting) {
        final Button check = new Button(parent, SWT.CHECK);
        check.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent arg0) {
                check.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_GRAY));
            }
        });
        return check;

    }
}