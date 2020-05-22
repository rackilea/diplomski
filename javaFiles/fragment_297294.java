public abstract class BaseActivity extends Activity 
{
    final protected void onCreate(Bundle savedInstanceState)
   {
    super.onCreate(savedInstanceState);
    onCreate_Impl(savedInstanceState);
   }

   abstract protected void onCreate_Impl(Bundle savedInstanceState);
}