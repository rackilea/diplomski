public class Q1 extends Activity {

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.q1_screen);
}

public void q1b1 (View view1)
    {
    Toast.makeText(this, "Right",
    Toast.LENGTH_SHORT).show();
    }
    public void q1b2 (View view2)
    {
    Toast.makeText(this, "Wrong! Try again",
    Toast.LENGTH_SHORT).show();
    }
    public void q1b3 (View view3)
    {
    Toast.makeText(this, "Wrong! Try again",
    Toast.LENGTH_SHORT).show();
    }
    public void q1b4 (View view4)
    {
    Toast.makeText(this, "Wrong! Try again",
    Toast.LENGTH_SHORT).show();
    }
}