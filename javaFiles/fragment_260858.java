public static SingletonObject getInstance()
{
   if ( instance == null )
   {
      instance = new SingletonObject();
   }
   return instance;

}