public String display() {

    StringBuilder sb = new StringBuilder(50);
    for (int i = 0; i < terms.size(); i++) {
        Term p = terms.get(i);
        sb.append(p.getElement());
        if(p.getNumber()!=1) {
            sb.append(p.getNumber());
        } 
    }

    return sb.toString();
}