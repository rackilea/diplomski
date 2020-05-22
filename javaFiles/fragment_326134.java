public class Model{
    private int id;
    private String attr;
    //other properties of the model

    public int getId(){
      return id;
    }
    public void setId(int id){
      this.id=id;
    }
    //other getters and setters

    //here we write methods to performs database operations 
    public void save(){
        //use "this" to get properties of object
        //logic to save to this object in database table TableModel as record
    }
    public void delete(int id){
        //logic to delete this object i.e. from database table TableModel 
    }
    public Model get(int id){
       //retrieve record   from table TableModel with this id
    }
   //other methods to get data from database.
}