public class YourActivity extends AppCompatActivity implements View.OnClickListener{

...
    @Override
            public void onClick(View view) {
                switch(view.getId()) {
                    case R.id.redButtonId:
                        Intent intent = new Intent(YourActivity.this, Activity2.class);
                        startActivity(intent);
                        break;
                    case R.id.greenButtonId:
                         Intent intent = new Intent(YourActivity.this, Activity3.class);
                        startActivity(intent);
                        break;
                }

            }