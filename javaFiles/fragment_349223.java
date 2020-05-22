public class ResourceModel extends DefaultTableModel{

   List<Resource> resources;


   public Object getValueAt(int row, int col){
      Resource resource = resources.get(row);

      if(col == 0){
         return resource.getName();
      }
      else if(col == 1){
         return resource.getOtherThing();
      }
      //so on

   }

   public int getRowCount(){
     return resources.size();
   }

}