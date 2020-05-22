import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new Gson();
    TypeDTO[] myTypes = gson.fromJson(new FileReader("input.json"), TypeDTO[].class);
    System.out.println(gson.toJson(myTypes));
  }
}

class TypeDTO
{
  int id;
  String name;
  ArrayList<ItemDTO> items[];
}

class ItemDTO
{
  int id;
  String name;
  Boolean valid;
}