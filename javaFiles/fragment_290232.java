@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    Item other = (Item) obj;
    if (itemNum != other.itemNum)
        return false;
    return true;
}