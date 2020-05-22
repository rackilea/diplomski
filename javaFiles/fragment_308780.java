public int getKey() {
    return key;
}

public V getValue() {
    return value;
}

@Override
public int compareTo(KeyValPair<V> toComp) {
    return -this.getValue().compareTo(toComp.getValue());
}