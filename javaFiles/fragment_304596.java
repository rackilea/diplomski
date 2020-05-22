@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    return result;
}