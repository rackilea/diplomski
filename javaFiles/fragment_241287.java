public class MyShowingListener {
private JComponent component;
public MyShowingListener(JComponent jc) { component=jc; }

public void hierarchyChanged(HierarchyEvent e) {
    if((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED)>0 && component.isShowing()) {
        System.out.println("Showing");
    }
}
}

JTable t = new JTable(...);
t.addHierarchyListener(new MyShowingListener(t));