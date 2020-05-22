public static class Vertex {
    public int x, y, z;
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Vertex)) return false;
        Vertex v = (Vertex)o;
        return x == v.x && y == v.y && z == v.z;
    }

    public int hashCode(){
        //  Use whatever prime numbers you like
        return x ^ y * 137 ^ z * 11317;
    }
}