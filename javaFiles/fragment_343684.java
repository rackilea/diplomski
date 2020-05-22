@Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        if (! isIntervalSelectionMode(e)){
            clearselection(e);
        }
    }

    public boolean isIntervalSelectionMode (MouseEvent e){
        boolean isIntervalSelection = false;
        if (e.getComponent() instanceof JTable){
            isIntervalSelection = ((JTable)e.getSource()).getSelectionModel().getSelectionMode() 
                        != ListSelectionModel.SINGLE_SELECTION;
        }else if (e.getComponent() instanceof JList){
            isIntervalSelection = ((JList<?>)e.getSource()).getSelectionModel().getSelectionMode() 
                    != ListSelectionModel.SINGLE_SELECTION;
        }
        return isIntervalSelection;
    }