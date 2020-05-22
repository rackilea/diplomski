if(centralPara.getNumOpen() > 1){
    centralPanel = centralList.get(centralPara.getCurrentFrame());
    JCheckBoxMenuItem reverseItem = centralPara.getReverseItem();
    boolean reversed = centralPanel.getReversed();
    reverseItem.setSelected(reversed);
 }