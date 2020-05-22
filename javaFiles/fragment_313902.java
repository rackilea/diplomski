package set;
import tree.*;
import list.*;

public class TreeSetIterator<E extends Comparable <E>> extends          TreeIterator<E>{
TreeSet<E> set;

public TreeSetIterator(TreeSet<E> set){
    super(set.tree);
    this.set=set;
}

public void remove(){
    set.tree=set.tree.remove(getLastGotten());
    set.size--;
}
}