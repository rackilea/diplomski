public String getPhone() {

    if (phone == null || /*this.*/phone.isEmpty()) {
        // Handle the error accordingly.
        return null; // example
    }
    String ret = "(" + this.phone.charAt(0) + "" + this.phone.charAt(1)
    + "" + this.phone.charAt(2) + ")" + this.phone.charAt(3) 
    + "" + this.phone.charAt(4) + "" + this.phone.charAt(5)
    + "" + this.phone.charAt(6) + "" + this.phone.charAt(7)
    + "" + this.phone.charAt(8) + "" + this.phone.charAt(9);
    return ret;
}