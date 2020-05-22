public class MainActivity extends AppCompatActivity {
  int[] marks = {1, 2, 4, 5};
  LinearLayout mLinearLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    mLinearLayout = new LinearLayout(this);
    setContentView(mLinearLayout);
    mLinearLayout.setOrientation(LinearLayout.VERTICAL);

    for (int i = 0; i <= marks.length; i++) {
        float markAverage = (float) i / marks.length;
        setMarkText(markAverage);

    }
}

  private void setMarkText(float markAverage) {
      TextView markTv = new TextView(this);
      markTv.setText(String.valueOf(markAverage));
      mLinearLayout.addView(markTv);
  }
}