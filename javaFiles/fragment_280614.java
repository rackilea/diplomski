public MyTree extends JTree {
    private boolean overrideIsEnable = false;
    public void setOverrideIsEnable(boolean b) { overrideIsEnabeld=true; }
    public boolean isOverrideIsEnable(boolean b) { return overrideIsEnabeld; }
    public boolean isEnabled() {
        if(overrideIsEnabled) return false;
        return super.isEnabled();
    }
}


class MyTreeUI extends SubstanceTreeUI {
protected void paintHorizontalPartOfLeg(Graphics g, Rectangle clipBounds,
        Insets insets, Rectangle bounds, TreePath path, int row,
        boolean isExpanded, boolean hasBeenExpanded, boolean isLeaf) {
if(this.tree instanceof MyTree)
try {
   Field f = SubstanceTreeUI.class.getDeclaredField("inside");
   f.setAccessible(true);
   Boolean v = (Boolean)f.get(this);
   f.set(this,Boolean.true);
   ((MyTree)this.tree).setOverrideIsEnable(true);
} catch(Throwable t) {
   //want to default back to substanceUI if this fails.
}
super.paintHoriz.....();
try{
    f.set(this,v);
    ((MyTree)this.tree).setOverrideIsEnable(true);
}catch(Throwable t) {
   //see above
}
}
//repeat for Vertical
}