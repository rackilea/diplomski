import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GroupData extends ArrayList<Group>
{
private static final long serialVersionUID = 1L;

public GroupData(){}

public void addGroup(Group group)
{
    this.add(group);
    saveGroupData();
}

public void removeGroup(Group group)
{
    this.remove(group);
    saveGroupData();
}

public void saveGroupData()
{
      try
      {
         FileOutputStream fileOut = new FileOutputStream("C:\\Users\\tester\\group-data.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);

         out.writeObject(this);

         out.close();
         fileOut.close();
      }
      catch(IOException i)
      {
          i.printStackTrace();
      }
}

public void loadGroupData()
{
      try
      {
         FileInputStream fileIn = new FileInputStream("C:\\Users\\tester\\group-data.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         GroupData tmp = (GroupData) in.readObject();

         this.clear();
         this.addAll(tmp);

         in.close();
         fileIn.close();
      }
      catch(IOException i)
      {
         i.printStackTrace();
         return;
      }
      catch(ClassNotFoundException c)
      {
         c.printStackTrace();
         return;
      }
}
}