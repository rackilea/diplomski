public class YourActivity extends AppCompatActivity {

    ........
    ................

    Stack stack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ........
        ................

        Button b1 = (Button) findViewById(R.id.btn1);
        b1.setOnClickListener(this);
        Button b2 = (Button) findViewById(R.id.btn2);
        b2.setOnClickListener(this);
        EditText e1 = (EditText) findViewById(R.id.etn1);

        // Stack
        stack = new Stack();
    }

    @Override
    public void onClick(View v) {
        TextView t1 = (TextView) findViewById(R.id.tvn);

        // Get id
        x =  e1.getId();

        if (v.getId()== R.id.btn1) {

            // Push
            stack.push(x);

            EditText e1 = (EditText) findViewById(R.id.etn1);
            e1.setId(0);

            t1.setText("Pushed");
            t1.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));
        }
        else if (v.getId() == R.id.btn2) {

            if (stack.empty()) {
                // Show message
                Toast.makeText(getApplicationContext(), "Stack is empty!", Toast.LENGTH_SHORT).show();
            } else {
                // Pop
                stack.pop();

                t1.setText("Poped");
               t1.setAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left));
            }
        }
    }
}