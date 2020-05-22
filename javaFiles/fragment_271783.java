public class WorldModel implements TreeModel {

     ...

     public void removeAllChildren(Turtle parent) {
         if (parent.getChildCount() == 0) return;
         Turtle[] children = parent.getChildren();
         int[] locations = new int[children.length());
         for(int loc = 0; loc < locations.length; loc++) {
            locations[i] = i;
         }
         parent.removeAllChildren();
         List<Turtle> path = new ArrayList<>();
         while (parent != null) {
             path.add(0, parent);
             parent = parent.getParent();
         }

         TreeModelEvent event = new TreeModelEvent(this, path, locations, children);
         // for each listener
              listener.treeNodesRemoved(event);   
     }
}