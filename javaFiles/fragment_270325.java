// clear onDataChange 
    parentLevel.clear();
    int level = 0;
    // populate the list 
    relatedParentNodeFinder(parentSnapshot, users.getUid(), level);
    // Use the list here. Shouldn't be empty 
}