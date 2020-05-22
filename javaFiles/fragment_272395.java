input_box_wrapper = findViewById( R.id.input_box_layout );

if ( input_box_wrapper == null )
    Log.i( "another", "it's null" );
else
{
    Log.i("another", "not null");

    if ( input_box_wrapper instanceof RelativeLayout )
        Log.i("another", "it's the root view");  
}