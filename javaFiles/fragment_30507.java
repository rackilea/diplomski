public class ControllerBean1 {
    private DataBean dataBean;

    public String submit() {
        MyClass theClass = (MyClass) dataTable.getRowData();
        String theId = theClass.getIdentityNumber();
        dataBean.setTheId(theId);
        return "page2";
    }

    // ...
}