public static void addCodes(Message root)
{
     if (root.getLeftChild() != null){
           root.getLeftChild().setCode(root.getLeftChild().getCode() + "0");
           addCodes(root.getLeftChild());
     }
     if (root.getRightChild() != null) {
           root.getRightChild().setCode(root.getRightChild().getCode() + "1");
           addCodes(root.getRightChild());

     }
}

public static void addCode(Message root)
{
     if (root.getLeftChild() != null){
           addCodes(root.getLeftChild());
           addCode(root.getLeftChild());
     }
     if (root.getRightChild() != null) {
           addCodes(root.getRightChild());
           addCode(root.getRightChild());
     }
}