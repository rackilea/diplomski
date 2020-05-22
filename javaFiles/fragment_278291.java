@Override
boolean equals(MyObj that){
    /* First check for null and all that stuff */
    ...
    return this.str.equals(that.getStr()) && this.num == that.getNum();
}