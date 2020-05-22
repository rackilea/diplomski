public class Tree {

   private ArrayList<Tree> theTrees;
   private String treeName;

   public Tree(String treeName) {
      this.treeName = treeName;
      this.theTrees = new ArrayList<Tree>();
   } 
   ...