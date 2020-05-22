public class Drawscreen extends ActionBarActivity 
{

//LinearLayout linear=(LinearLayout)findViewById(R.id.main_layout);
//draw=(Drawthegraph)findViewById(R.id.main_layout);

private Drawthegraph drawthegraph;

@Override
protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
    ActionBar actionbar=getSupportActionBar();
    actionbar.show();
    this.drawthegraph=new Drawthegraph(this);
    setContentView(drawthegraph);
    drawthegraph.setBackgroundColor(color.Ivory);
}

@Override
public boolean onCreateOptionsMenu(Menu menu) 
{
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.drawscreen, menu);
    return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) 
{
    switch (item.getItemId()) 

        case R.id.undo:/*Call method of view here*/
            drawthegraph.decrease_lines();
                        break;
    }
    return super.onOptionsItemSelected(item);
}   
}