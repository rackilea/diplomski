class Node {
  String id;
  String text;
  // ...
  List<Node> children;
}

class Filesystem {

   Node browse(File path, int depth) {
       Node node = new Node(file);
       if( depth > 0 ) {
          for(File f : file.listFiles()) {
             Node child = browse(f, depth - 1);
             node.children.add(child);
          }
       }
       return node;
   }
}