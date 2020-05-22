public class NonActivityClass {

    Context context;
    View v;
    public NonActivityClass(Context context, View v) {
        this.context = context;
        this.v = v;
    }

    public void test() {
        Button btn = (Button) v.findViewById(R.id.btn);
        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "Hello I am inside Non Activity Class",
                        1).show();

            }
        });
    }
}