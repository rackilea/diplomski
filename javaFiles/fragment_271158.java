@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ip == null) ? 0 : ip.hashCode());
    result = prime * result + ((url == null) ? 0 : url.hashCode());
    return result;
}