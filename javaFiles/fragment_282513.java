public class Singleton
{
      private Singleton()
      {
            print("Constructor");
      }

      private static Singleton instances[] = new Singleton[4];

      private static Boolean initiated = false;

      public static Singleton getInstance(int index)
      {
          tryInitiate();

          if(instances[index] == null)
          {
              instances[index] = new Singleton();
          }

          return instances[index];
      }

      private static Boolean tryInitiate()
      {
          if(initiated) return false;

          for (int i = 0; i < instances.length; i++)
          {
              instances[i] == null;
          }

          initiated = true;

          return true;
      }
}