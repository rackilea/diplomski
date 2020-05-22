@Override
public boolean equals(Object obj) {
    if (obj == null) {
        return false;
    }
    if (getClass() != obj.getClass()) {
        return false;
    }
    final LocalDate other = (LocalDate) obj;
    System.out.println(toString() + ".equals(" + obj.toString() + ')');
    if (!Objects.equals(this.hour, other.hour)) {
        return false;
    }
    if (!Objects.equals(this.minute, other.minute)) {
        return false;
    }
    if (!Objects.equals(this.second, other.second)) {
        return false;
    }
    return true;
}