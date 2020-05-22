public class TreeNodeFactory implements Operator<MyAppTreeNode> {
    public MyAppTreeNode operateAlpha(DataTypeAlpha data) {
      return new AlphaTreeNode(data);
    }
    ...
 }

 public class MyAppTreeNode {
   static TreeNodeFactory factory = ...;
   static MyAppTreeNode createTreeNodeForDataType(DataType dataType) {
     return dataType.accept(factory);
   }       
 }