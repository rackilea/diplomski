public class Forest {
    public String forestName;

    HashMap<Integer, Tree> trees = new HashMap<>();

    public Forest(String forestName){
        this.forestName=forestName;

        //initialize trees
        trees.put(4, new Tree(4, "redleaef"));
    }

    public void updateTreeName(int id, String Name){
        trees.get(id).treeName = Name;
    }

    public static void main(String[] args) {
        Forest greenforest = new Forest("name");
        // create some tree's in the greenforest.
        greenforest.updateTreeName(4, "red leafe");
    }
}