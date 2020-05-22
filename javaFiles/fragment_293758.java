for(Iterator<Object> iter = list.iterator(); iter.hasNext();) {
    Object o = iter.next();
    o.update();
    if(o.collide == true) {
        iter.remove();
    } 
}