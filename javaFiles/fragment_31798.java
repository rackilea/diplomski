public static int i = 0;  
public static Link.Node findnthToLastRecursion(Link.Node node, int pos) {

    Link.Node result = node;

    if(node != null) {
        result = findnthToLastRecursion(node.next, pos);

        if(i++ == pos){
            result = node;
        }
    }
    return result;
}