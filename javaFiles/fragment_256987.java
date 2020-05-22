// Theatre:
@Override
public boolean equals(Object obj) {
    if (!(obj instanceof Theatre)) return false;

    Theatre that = (Theatre) obj;

    return this.name.contains(that.name) || that.name.contains(this.name);
}