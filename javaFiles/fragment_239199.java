void print() {
    Node travel = head;
    while(travel!= null) {
        System.out.println(travel.getExponent() + " " + travel.getCoefficient());
        travel = travel.getLink();
    }
}