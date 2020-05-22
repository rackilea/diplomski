import java.beans.*;

public class Test {

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        PropertyDescriptor pd = new PropertyDescriptor("checked", Test.class);
        System.out.println(pd.getReadMethod().invoke(test));
    }

    public boolean isChecked() {
        System.out.println("isChecked called!");
        return true;
    }

    public void setChecked(boolean checked) {
    }
}