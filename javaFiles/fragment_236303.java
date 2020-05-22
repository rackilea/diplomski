public static final long TIME_CONSTANT = 3*1000L;

final TextView loadingMessage1 = (TextView)this.findViewById(R.id.loadingMessage1);
int count = 0;
final Handler handler = new Handler();

handler.postDelayed(new TextChanger("Whatever 1"), TIME_CONSTANT);
handler.postDelayed(new TextChanger("Whatever 2"), 2 * TIME_CONSTANT);