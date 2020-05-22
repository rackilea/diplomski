public String getCoins() {
    /* Assuming you include `purseName` member in the purse class for storing purse name */
    StringBuilder sb = new StringBuilder(this.purseName + "[");
    for(Coin c : coins) {
        sb.append(c.getCoin() + " " + c.getValue() + ", ");
    }
    return sb.append("]").toString();
}