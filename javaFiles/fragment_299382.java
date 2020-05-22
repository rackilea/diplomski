@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + sec;
    return result;
}

@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null) {
        return false;
    }
    if (!(obj instanceof Time)) {
        return false;
    }
    Time other = (Time) obj;
    if (sec != other.sec) {
        return false;
    }
    return true;
}