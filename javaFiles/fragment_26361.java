@Override
        public void mouseClicked(MouseEvent e) {
            if(chckbxSelectAll.isSelected()){

                for(int i=0;i<table.getRowCount();i++)
                table.getModel().setValueAt(true, i, 5);

            }else{

                for(int i=0;i<table.getRowCount();i++)
                    table.getModel().setValueAt(false, i, 5);                   
            }       

        }