public String toString() {
    String returnString = super.toString();
    returnString += String.format(Constant.FORMAT, "Color:", this.color);

    return returnString;
}