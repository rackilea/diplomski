jSplitPane1 = new JSplitPane();
 jSplitPane2 = new JSplitPane();

 jSplitPane1.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
 jSplitPane1.setRightComponent(jSplitPane2);
 jSplitPane2.setOrientation(JSplitPane.VERTICAL_SPLIT);

 jSplitPane1.setTopComponent(jPanel1);
 jSplitPane1.setBottomComponent(jPanel2);