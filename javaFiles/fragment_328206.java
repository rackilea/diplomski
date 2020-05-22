private void init(){

     //...

     grid.gridy = 4;
     grid.gridx = 0;
     add(optionList, grid);
     grid.gridx = 1;
     cercleSelectionne = ((CercleItemOption) optionList.getSelectedItem());
     add(cercleSelectionne.getCercle(), grid);

     optionList.addItemListener(itemEvent -> {
                remove(cercleSelectionne.getCercle());
                grid.gridx = 1;
                grid.gridy = 4;
                cercleSelectionne = (CercleItemOption) itemEvent.getItem();
                add(cercleSelectionne.getCercle(), grid);
                revalidate();
                repaint();
     });

}