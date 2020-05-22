import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


class DependencyDataCollection
{
    // makte them fnal, then you hava an immutible object and your code is much safer.
    // in your case you had noset methods so it was safe, but always try to make things final.
    private final int sNo;
    private final String sessionID;
    private final int noOfDependency;
    private final int noOfRejection;
    private final int totalValue;

    public DependencyDataCollection(final int    sNo, 
                                    final String sessionID, 
                                    final int    noOfDependency, 
                                    final int    noOfRejection, 
                                    final int    totalValue)
    {
        this.sNo            = sNo;
        this.sessionID      = sessionID;
        this.noOfDependency = noOfDependency;
        this.noOfRejection  = noOfRejection;
        this.totalValue     = totalValue;
    }

    public int getSNo()
    {
        return sNo;
    }

    public String getSessionID()
    {
        return sessionID;
    }

    public int getNoOfDependency()
    {
        return noOfDependency;
    }

    public int getNoOfRejection()
    {
        return noOfRejection;
    }

    public int getTotalValue()
    {
        return totalValue;
    }
}

class DependencyStack
{
    // change the type to be as generic as poosible - List interface
    // added generics so you get compile time safety and don't use casts later on
    // renamed it to something meaningful
    private final List<DependencyDataCollection> dependencies;

    // use an ArrayList instead of a LinkedList, it'll be faster since you are not inserting/deleting
    // into the middle of the list
    {
        dependencies = new ArrayList<DependencyDataCollection>();
    }

    // your Stack shouldn't know how to make the collections... (in my opinion)
    public void add(final DependencyDataCollection ddc)
    {
        dependencies.add(ddc);
    }

    public int size()
    {
        return dependencies.size();
    }

    // the next 3 methods are just convenience since you don't know if someione
    // will want to write to a file or a writer instead of a stream
    public void show()
    {
        show(System.out);
    }

    public void show(final OutputStream out)
    {
        show(new OutputStreamWriter(out));
    }

    public void show(final Writer writer)
    {
        show(new PrintWriter(writer));
    }

    public void show(final PrintWriter writer)
    {
        // use the new for-each instead of the old style for loop
        // this also uses an iterator which is faster than calling get
        // (well on an ArrayList it probably is about the same, but a LinkedList it'll be faster)
        for(final DependencyDataCollection ddc : dependencies)
        {
            writer.println(ddc.getSNo()            + "   " +
                           ddc.getSessionID()      + "   " +
                           ddc.getNoOfDependency() + "   " +
                           ddc.getNoOfRejection()  + "   " +
                           ddc.getTotalValue());
        }
    }

    public int returnIndexOfSession(final String sessionID)
    {
        DependencyDataCollection foundDDC;
        final int                retVal;

        foundDDC = null;

        for(final DependencyDataCollection ddc : dependencies)
        {
            if(ddc.getSessionID().equals(sessionID))
            {
                foundDDC = ddc;
                break;
            }
        }

        // deal with the fact that you might have not found the item and it would be null.
        // this assumes -1 is an invalid session id
        if(foundDDC == null)
        {
            retVal = -1;
        }
        else
        {
            retVal = foundDDC.getSNo();
        }

        return (retVal);
    }

    public static void main(final String[] args)
    {
        DependencyStack ds = new DependencyStack();
        ds.add(new DependencyDataCollection(1,"a",0,0,0));
        ds.add(new DependencyDataCollection(1,"a",0,0,0));
        ds.show();

        //System.out.println(ds.returnIndexOfSession("a"));

//        DependencyDataCollection ddc = new DependencyDataCollection(1,"a",0,0,0);
//        System.out.println(ds.indexOf(ddc));
    }
}