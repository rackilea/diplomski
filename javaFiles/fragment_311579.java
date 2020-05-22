import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateInArrayList 
{
    public static void main(String args[])
    {
        Check c1 = new Check(1,"one");
        Check c2 = new Check(2,"two");
        Check c3 = new Check(3,"three");


        Check c4 = new Check(1,"one");
        Check c5 = new Check(2,"two");
        Check c6 = new Check(3,"three");

        Map<Integer, Check> map = new HashMap<Integer, Check>();
        map.put( c1.getId() , c1 );
        map.put( c2.getId() , c2 );
        map.put( c3.getId() , c3 );
        map.put( c4.getId() , c4 );
        map.put( c5.getId() , c5 );
        map.put( c6.getId() , c6 );

        System.out.println( map );
    }

}

class Check
{
    public Check(int id,String name)
    {
        this.id = id;
        this.name = name;
        this.creationTme = new Date();
        System.out.println("id :"+this.id+" ::"+this.getCreationTme().getTime());
    }
    private Integer id;
    private String name;
    private Date creationTme;
    public int getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Date getCreationTme() {
        return creationTme;
    }
    public void setCreationTme(Date creationTme) {
        this.creationTme = creationTme;
    }
    @Override
    public int hashCode()
    {
        return this.id;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Check && ((Check)obj).id == this.id)
            return true;
        else return false;
    }

    public String toString()
    {
        final String TAB = "    ";

        String retValue = "";

        retValue = "Check ( "
            + "id = " + this.id + TAB
            + "name = " + this.name + TAB
            + "creationTme = " + this.creationTme.getTime() + TAB
            + " )";

        return retValue;
    }


}