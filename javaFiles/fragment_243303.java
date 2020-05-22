public class Size {
    private String name;
    private double price;
    private boolean selected;
}

public class example {
    private Size selectedSize;
    private ArrayList<Size> sizes;

    public example() {
        Size s1 = new Size();
        Size s2 = new Size();
        Size s3 = new Size();

        sizes.add(s1);
        sizes.add(s2);
        sizes.add(s3);

        if (someCondition == true){
            // Select s1
            selectedSize = s1;
        }
    }
}