public boolean equals(Object obj) {

    // Reflexive equality: did I get passed myself?
    if(this == obj){
        return true;
    }

    if (obj == null || obj.getClass() != this.getClass()) {
        return false;
    }

    Coor temp = (Coor) obj;
    return temp.x == this.x && temp.y == this.y;
}