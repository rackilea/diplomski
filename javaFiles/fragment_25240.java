public boolean equals(Object obj) {
    if(this == obj) return true;
    if(!(obj instanceof Sandbox)) return false;
    Sandbox that = (Sandbox)obj;
    return this.a == that.a;
}