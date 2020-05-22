import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

class SerializableClass implements Serializable
{
   private writeObject(ObjectOutputStream out) {}
   private readObject(ObjectInputStream in) {}
}

public class DerivedSerializableClass extends SerializableClass
{
   public static void main(String[] args)
   {
      DerivedSerializableClass dsc = new DerivedSerializableClass();

      if (dsc instanceof DerivedSerializableClass) {} // fine
      if (dsc instanceof Serializable) {} // fine because check is done at runtime
      if (dsc instanceof String) {} // error because compiler knows dsc has no derivation from String in the hierarchy

      Object o = (Object)dsc;
      if (o instanceof DerivedSerializableClass) {} // fine because you made it Object, so runtime determination is necessary
   }
}