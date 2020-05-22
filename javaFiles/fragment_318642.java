private int id;

/*Default getter setter*/
public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}

/*String based getter setter*/
public String getIdStr() {
    return Integer.toString(id);
}
public void setId(String id) throws NumberFormatException {
    this.id = Integer.parseInt(id); // Null check to be added 
}