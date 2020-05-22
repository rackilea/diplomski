public class Utilities 
{
public static View.OnClickListener CreateOnClickListener(final Context context,final Class<?> cls)
{
    View.OnClickListener listener = new View.OnClickListener() 
    {
            public void onClick(View v) 
            {
                Intent window = new Intent(context, cls);
                context.startActivity(window);
            }
    };

    return listener;
}
}