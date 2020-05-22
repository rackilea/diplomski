@Override
public int compareTo(Contact other) {
    if (this.lastName.compareTo(other.lastName) == 0) {
        return this.name.compareTo(other.name);
    } else {
        return this.lastName.compareTo(other.lastName);
    }
}