@Override
public int compareTo(Employee o) {
    int result = this.getName().compareTo(o.getName());
    if (result == 0) {
        result = Integer.compare(this.getAge(), o.getAge());
        if (result == 0) {
            return Integer.compare(this.getExp(), o.getExp());
        }
        return result;
    }
    return result;
}