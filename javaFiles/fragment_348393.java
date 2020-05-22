public class Vertex {

    private int v;
    private int label;

 public static void main(String[] args) {
    Map<Vertex, String> map = new HashMap<Vertex, String>();

    Vertex vertex = new Vertex();
    vertex.v = 5;
    vertex.label = 10; 

    map.put(vertex, "vertex");

    Vertex vertex2 = new Vertex();
    vertex2.v = 5;
    vertex2.label = 100;  

    System.out.println("Value:: "+ map.get(vertex2));
}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + v;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (v != other.v)
            return false;
        return true;
    }
}