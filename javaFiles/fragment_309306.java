@XmlRootElement(name="return")
public class returnBean {
   private ArrayList<Row> rows;

   public ArrayList<Row> getRows(){
       return rows;
   }

   public void setRows(ArrayList<Row> rows){
       this.rows = rows;
   }
}