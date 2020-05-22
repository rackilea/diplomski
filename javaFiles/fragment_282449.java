//  Vertical orientation
//
//  MultiButton
//      |    
//      |-- Container
//      |      | 
//      |      |-- Container
//      |      |      |
//      |      |      |-- Label (name=Line2)    <--- this one!
//      |      |      |-- Label (name=Line3)
//      |      |      |-- Label (name=Line4)
//      |      |
//      |      |-- Label (name=Line1)
//      |              
//      |-- Container
//      |      |
//      |      |-- Label (name=icon)
//      |  
//      |-- Container
//             |
//             |-- Button (name=emblem)
//
// ------------------------------------------------------------
//
//  Horizontal orientation
//
//  MultiButton
//      |    
//      |-- Container
//      |      | 
//      |      |-- Container
//      |      |      |
//      |      |      |-- Label (name=Line3)
//      |      |      |-- Label (name=Line4)
//      |      |
//      |      |-- Label (name=Line1)
//      |      | 
//      |      |-- Container
//      |      |      |
//      |      |      |-- Label (name=Line2)    <--- this one!
//      |      |      
//      |-- Container
//      |      |
//      |      |-- Label (name=icon)
//      |  
//      |-- Container
//             |
//             |-- Button (name=emblem)
//
private void setLine2Color(MultiButton multiButton, int color) {
    List<Component> childsLevel1 = multiButton.getChildrenAsList(false);
    Container firstContainerLevel1 = (Container)childsLevel1.get(0);
    List<Component> childsLevel2 = firstContainerLevel1.getChildrenAsList(false);
    Container targetContainerLevel2 = (Container)childsLevel2.get(multiButton.isHorizontalLayout() ? 2 : 0);
    List<Component> childsLevel3 = targetContainerLevel2.getChildrenAsList(false);
    Label firstLabelLevel3 = (Label)childsLevel3.get(0);
    firstLabelLevel3.getAllStyles().setFgColor(color);
}