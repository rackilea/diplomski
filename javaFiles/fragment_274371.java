public class PrivateData
{
   public Object publicInput_;
   private long privateInputPointer_;

   private native static long jniStoreObject(Object privateInput); 

   public PrivateData(Object publicInput, Object privateInput)
   {
      publicInput_ = publicInput;
      privateInput_ = jniStoreObject(privateInput);
   }
}