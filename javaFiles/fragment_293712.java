import java.util.List;
import java.util.ArrayList;

class FunkyObject
{
    /** a list of other FunkyObject that this object is linked to */

    List<FunkyObject> referenceList = new ArrayList<FunkyObject>();

    /** creates a link between this object and someObject */

    public addRefrerence(FunkyObject someObject )
    {
        referenceList.add(a);
    }
}