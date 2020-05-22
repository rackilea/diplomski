public class ButtonListener implements View.OnClickListener {
    private Intent g;
    private Context caller;

    public ButtonListener(Intent f, Context caller) {
        this.g = f;
        this.caller = caller;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button5:
                caller.startActivity(g);
                break;
        }
    }
}