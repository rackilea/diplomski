public class KeepOpenCheckBox extends BasicCheckBoxMenuItemUI{
    public static ComponentUI createUI(JComponent c){
        return new KeepOpenCheckBox();
    }

    protected void doClick(MenuSelectionManager msm){
        menuItem.doClick(0);
    }
}