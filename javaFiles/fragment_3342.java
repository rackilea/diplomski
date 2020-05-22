// If at least one child is selected, selecting also the parent
//            if (childCheckedNode.isSelected) {
//                parentCheckedNode.isSelected = true;
//            }
        }
   //check the parent if all children are selected
    if (parentCheckedNode.allChildrenSelected) {
        parentCheckedNode.isSelected = true;
    }