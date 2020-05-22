public class Message implements Serializable {
   public List<Message> flattenChildren() {
       ArrayList<Message> childs = new ArrayList();
       if(children != null) {
         for (Message m : children) {
            // First add the child then request the flattened children of that child.
            childs.add(m);
            childs.addAll(m.flattenChildren());
         }
       }
       return childs;
   }
}