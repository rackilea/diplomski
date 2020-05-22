public class DecidableTree<V> extends Node<DecidableTree<V>, V> {

    public DecidableTree(V value) {
        super(value);
    }

    public void randomInvolvedFunction(){
        for(DecidableTree<V> child : this.getChildren()){
            System.out.println(child.getVal());
        }
    }
}