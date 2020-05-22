class IntervalSearchTree {
     var root=new IntervalNode(null,null,null,null,null);

  class IntervalNode(var left:IntervalNode,var start:Integer,var end:Integer,var maxEnd:Integer,var right:IntervalNode);

    def add(start:Integer,end:Integer ):Unit={
      var node:IntervalNode=root
      while(node!=null){
        if(end>node.maxEnd)
          node.maxEnd=end
        if (start < node.start) {
                if (node.left == null) {
                    node.left = new IntervalNode(null, start, end, end, null);
                    return;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new IntervalNode(null, start, end, end, null);
                    return;
                }
                node = node.right;
            }
      }
      root =  new IntervalNode(null, start, end, end, null);
    }

    def overlap(start:Integer,end:Integer):Unit={

      var intervalNode:IntervalNode=root;
      while (intervalNode != null) {
         if (intersection(start, end, intervalNode)){
           println(intervalNode.start+"-"+intervalNode.end)
         }
         if (leftSubTree(start, end, intervalNode.left)) {
                intervalNode = intervalNode.left;


            } else {

                intervalNode = intervalNode.right;

            }


      }

    }

    def within(start:Integer,end:Integer):Unit={
        var intervalNode:IntervalNode = root;
        while (intervalNode != null) {
           if (subset(start, end, intervalNode)){
           println(intervalNode.start+"-"+intervalNode.end)
         }
         if (leftSubTree(start, end, intervalNode.left)) {
                intervalNode = intervalNode.left;


            } else {

                intervalNode = intervalNode.right;

            }
        }

    }


    def subset(start:Integer,end:Integer,intervalNode:IntervalNode):Boolean={
      return start<intervalNode.start  && end >intervalNode.end ;
    }

    def intersection(start:Integer,end:Integer,intervalNode:IntervalNode):Boolean={
      return start < intervalNode.end && end > intervalNode.start;
    }

    def leftSubTree(start:Integer,end:Integer,intervalLeftSubtree:IntervalNode):Boolean={
      return intervalLeftSubtree != null && intervalLeftSubtree.maxEnd > start;
    }


    def main(args: Array[String]): Unit = {
      var intervalSearchTree=new IntervalSearchTree()
        intervalSearchTree.add(17, 19);
        intervalSearchTree.add(5, 8);
        intervalSearchTree.add(21, 24);
        intervalSearchTree.add(22, 24);
        intervalSearchTree.add(20, 26);
        intervalSearchTree.add(20, 24);
        intervalSearchTree.add(4, 8);
        intervalSearchTree.add(5, 9);
        intervalSearchTree.add(15, 18);
        intervalSearchTree.add(7, 10);
        intervalSearchTree.add(16, 22);

        //Input for testing overlaps 
        println("Overlaps");
        intervalSearchTree.overlap(23, 25);
        //Input for testing overlaps
        println("Within");
        intervalSearchTree.within(4, 25);
    }




}