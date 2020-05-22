ListIterator<VRPNode> iterator = this.routeList.listIterator();

while (iterator.hasNext()) {

    VRPNode current = iterator.next();

    if (iterator.hasPrevious())
        this.routeCost += vrp.distance(iterator.previous(), current); 

}