private void printDetails(TreePath me) {
                DefaultMutableTreeNode mee = (DefaultMutableTreeNode) me.getLastPathComponent();
                TreePath parent = me.getParentPath();
                if(parent == null){
                    return;
                }
                DefaultMutableTreeNode lastPathComponent = (DefaultMutableTreeNode) (parent.getLastPathComponent());
                for (int i = 0; i < lastPathComponent.getChildCount(); i++) {
                    if (lastPathComponent.getChildAt(i).equals(mee)) {
                        System.out.println(mee.getUserObject() + " I am the " + i + "th child of " + lastPathComponent.getUserObject());
                    }
                }
                printDetails(parent);
            }