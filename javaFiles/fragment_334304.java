} else {
    if(node1.getData().getLocation().compareTo(newLoc) == -1) 
        return findPixel(node1, node2.getLeft(), gobj);
    else
        return findPixel(node1, node2.getRight(), gobj);
}
return false;