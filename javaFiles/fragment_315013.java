public class Claims{
    long a, as, bs;

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        int button = data.getIntExtra("k1", 0);
        String result;

        if (button == 1) {
            result = data.getStringExtra("text");
            as=Long.parseLong(result);
        } else if(button==2) {
            result = data.getStringExtra("text");
            bs=Long.parseLong(result1);
        }

        long amount=as+bs;
        Toast.makeText(getActivity(),amount+"", Toast.LENGTH_LONG).show();
    }
}