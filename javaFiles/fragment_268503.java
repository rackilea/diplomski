public class MyClass {
    private final int labelsSize;
    private final Label[][] labels;
    public MyClass(final int labelsSize) { 
        this.labelsSize = labelsSize;
        this.labels = new Label[labelsSize][labelsSize];
    }
    // ...
    for (int i=0; i<labelsSize; i++) {
        for (int j=0; j<labelsSize; j++) {
            labels[i][j]=new Label(panel, SWT.SHADOW_OUT);
            labels[i][j].setImage(empty);
        } 
    }
}