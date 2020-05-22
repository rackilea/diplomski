@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    if(Objects.nonNull(this.name)) {
        sb.append(this.name+",");
    }
    if(Objects.nonNull(this.location)) {
        sb.append(this.location+",");
    }
    if(Objects.nonNull(this.tag)) {
        sb.append(this.tag);
    }

    return sb.toString();
}