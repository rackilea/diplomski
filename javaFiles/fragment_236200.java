public class MyTable extends JXTable{
    public MyTable(AbstractTableModel model){
        super(model);
        //remove items for horizontal scrollbar, pack and packall
        this.getActionMap().remove("column.horizontalScroll");
        this.getActionMap().remove("column.packAll");
        this.getActionMap().remove("column.packSelected");
        //first two columns should be shown permanently
        ColumnControlButton controlButton = new ColumnControlButton(this){
            @Override
            protected ColumnControlPopup createColumnControlPopup(){
                return (new NFColumnControlPopup());
            }

            class NFColumnControlPopup extends DefaultColumnControlPopup{
                @Override
                public void addVisibilityActionItems(List<? extends AbstractActionExt> actions){
                    for(int i = 0; i < actions.size(); i++){
                        AbstractActionExt action = actions.get(i);
                        JCheckBoxMenuItem chk = new JCheckBoxMenuItem(action);
                        chk.setUI(new KeepOpenCheckBox());
                        //disable first two items but they will be still shown greyed
                        if(i == 0 || i == 1){
                            chk.setEnabled(false);
                            chk.setSelected(false);
                        }
                        else{
                            chk.setEnabled(true);
                            chk.setSelected(true);
                        }
                        chk.addItemListener(action);
                        super.addItem(chk);
                    }
                }
            }
        };
        this.setColumnControl(controlButton);
    }
}