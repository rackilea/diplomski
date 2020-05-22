public class MainActivity extends AppCompatActivity {

    private class YourListener implements View.OnClickListener {
        private TextView textView;
        private Button[] buttons;
        private int correctButtonId;
        public YourListener(TextView textView, Button[] buttons, int correctButtonId) {
            this.textView = textView;
            this.buttons = buttons;
            this.correctButtonId = correctButtonId;
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == correctButtonId) {
                MainActivity.this.correctDialog(textView, buttons);
            } else {
                MainActivity.this.wrongDialog(textView, buttons);
            }
        }
    }
}