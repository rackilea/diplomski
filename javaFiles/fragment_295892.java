import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HybridFile implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<byte[]> data = new ArrayList<>();

    public void addRow(String s,byte[] a)
    {
        data.add(s.getBytes()); // add encoding if necessary
        data.add(a);
    }

    @Override public String toString()
    {
        StringBuilder sb = new StringBuilder();
        synchronized (data)
        {
            for(int i=0;i<data.size();i+=2)
            {
                sb.append(new String(data.get(i)));
                sb.append(Arrays.toString(data.get(i+1))+"\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        HybridFile hf = new HybridFile();
        hf.addRow("peter",new byte[] {1,2,3});
        hf.addRow("jaqueline",new byte[] {4,5,6});

        try(ObjectOutput output = 
                new ObjectOutputStream(
                        new BufferedOutputStream(new FileOutputStream("hybrid"))))
        {output.writeObject(hf);}

        ObjectInput input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("hybrid")));
        HybridFile hf2 = (HybridFile)input.readObject();

        System.out.println(hf2);
    }
}