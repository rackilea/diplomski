public String toString(){

    SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd);

    String str = "";

    str += "Id: " + this.id + "\n";
    str += "Price: " + this.price + "\n";
    .
    .
    str += f.format(date);  

    return str;

}