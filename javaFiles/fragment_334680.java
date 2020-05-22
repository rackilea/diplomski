public class ImageViewer extends ViewPart {

    String text;
    protected Label labelMsg1;

    public ImageViewer() {}

    public void setA(String val) {
        String text=val; 
        labelMsg1.setText(val);   
    }

    @Override
    public void createPartControl(Composite parent) {
        if (labelMsg1 == null) {
            labelMsg1 = new Label(parent, SWT.NONE);  
            labelMsg1.setText("Hello");
        } 
    }

    public void setFocus() {}

}