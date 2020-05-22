public String getMyAttribute() {
    // safe return (if null returns "")
    return this.myAttribute == null ? "" : this.myAttribute;
}

public void setMyAttribute(String myAttribute) {
    // validations
    if (myAttribute.startsWith("My") {
       this.myAttribute = myAttribute;
    } else {
       this.myAttribute = "My" + myAttribute;
    }
}