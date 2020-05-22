import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


class SequenceModel implements Serializable
{
    public SequenceModel(Object a, boolean b)
    {
        sequenceRawData = a;
        isProcessedByRequest = b;
    }

    public String toString()
    {
        return (String)sequenceRawData + isProcessedByRequest + " SeqModel ";
    }

    private Object sequenceRawData;    
    private boolean isProcessedByRequest;
}

class SequenceData implements Serializable
{
    public SequenceData(ArrayList<SequenceModel> a, String b)
    {
        recordedSequenceData = a;
        sequenceUrl = b;
    }

    public String toString()
    {
        return recordedSequenceData + sequenceUrl + " SeqData ";
    }

    private ArrayList<SequenceModel> recordedSequenceData;
    private String sequenceUrl;
}

class SequenceHolder implements Serializable
{
    ArrayList<SequenceData> data;

    public String toString()
    {
        return data + " SeqHol ";
    }

    public SequenceHolder(ArrayList<SequenceData> a)
    {
        data = a;
    }


    public void writeSequenceList() throws FileNotFoundException, IOException {        
        FileOutputStream fout = new FileOutputStream(Test.file);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(data);
        oout.close();
        fout.close();        
    }

    public ArrayList<SequenceData> loadSequenceList() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(Test.file);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        this.data = (ArrayList<SequenceData>) in.readObject();
        in.close();
        fileIn.close();
        return data; // load from de-serialization
    }
}

public class Test 
{
    public static File file = new File("abc.txt");

    public static void main(String[] args) 
    {

        SequenceModel obj = new SequenceModel("abc", false);
        ArrayList list = new ArrayList(); list.add(obj);
        SequenceData obh = new SequenceData(list, "str");
        ArrayList l2 = new ArrayList();
        l2.add(obh);
        SequenceHolder obi = new SequenceHolder(l2);
        try {
        obi.writeSequenceList();

            System.out.println(obi.loadSequenceList());
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}