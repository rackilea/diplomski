@Override
public boolean equals(Object obj) {
    if (obj == null) return false;
    if (obj.getClass() != getClass()) return false;
    Vertex other = (Vertex)obj;
    return (this.id == other.id);
}