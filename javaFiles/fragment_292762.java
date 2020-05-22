Iterator<College> iter = collegeList.iterator();
while(iter.hasNext()) {
    College clg = iter.next();
    if(!clg.approve()) {
        iter.remove();
    }
}