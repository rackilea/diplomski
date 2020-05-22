public class Tree {

    private class Node {
        public int value;
        public List<Node> = new children ArrayList<Node>();
        public List<Node> = new parents ArrayList<Node>();
        public static final INFINITY = Integer.MAX_VALUE;

        public void addChild(Node n) {
            children.add(n);
        }

        public void addParent(Node n) {
            parents.add(n);
        }

        public int getValue() {return value;}

        //What is the value from H -> I -> L (H+I+L):
        int getValueToNode(Node Destination, HashSet<Node> s) {
           int minValue = INFINITY;
           int value = 0;

           if(s.contains(this)) return INFINITY; //we already checked this
           s.add(this);
           if(this.equals(Destination)) return Destination.value();

           for(int i = 0; i < children.size(); i++) {
               Node c = children.get(i);
               int value = c.getValueToNode(Destination);
               if (value != Integer.MAX_VALUE && value < minValue) {
                   minValue = value + this.getValue();
               }
           }

           for(int i = 0; i < parents.size(); i++) {
               Node p = parents.get(i);
               value = p.getValueToNode(Destination);
               if (value != Integer.MAX_VALUE && value < minValue) {
                   minValue = value + this.getValue();
               }
           }
           return minValue;
        }

        //Who will be affected if H changes. H -> B,C,D -> A
        public int getDependency(ArrayList<Node> affected) {
          for(int i = 0; i < children.size(); i++) {
               Node c = children.get(i);
               affected.add(c);
           }

           for(int i = 0; i < parents.size(); i++) {
               Node p = parents.get(i);
               affected.add(p);
           }
        }

        //What are the dependencies of H? F, G, E.
        List<Node> getDependency() {
           List<Node> dependency = new ArrayList<Node>();
           for(int i = 0; i < parents.size(); i++) {
               Node p = parents.get(i);
               for(int j= 0 ; j < p.children.size(); j++) {
                   Node c = p.children.get(i);
                   if(!c.equals(this)) dependency.add(c);
               }
           }
           return dependency;
        }
    }

    //data here.
    private Map<String, Node> mapping = new HashMap<String, Node>();

    public connectParentToChild(String parent, String child) {
        Node p = getNode(parent);
        Node c = getNode(child);
        p.addChild(c);
        c.addParent(p);
    }

    public int getValue(String first, String second) {
        a = getNode(first);
        b = getNode(second);
        HashSet<Node> s = new HashSet<Node>();
        return a.getValueToNode(b, s);
    }

    private Node getNode(String s) {
        if(!mapping.containsKey(s)) {
           mapping.put(s, new Node(...));
        }
        return mapping.get(s);
    }

    //members here.
}