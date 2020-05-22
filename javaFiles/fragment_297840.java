public void changeSelection(int rowIndex, int columnIndex, boolean toggle, boolean extend)
            {
                if(!(toggle && jt.getSelectedRowCount() == 1))
                {
                    super.changeSelection(rowIndex, columnIndex, toggle, extend);
                }
            }