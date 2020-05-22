public int hashCode() {
    final int prime = 31;
    int res = (sIP != null) ? sIP.hashCode() : 1;
    res = res * prime + ID;
    return res * prime + Double.hashCode(RSSi);
}