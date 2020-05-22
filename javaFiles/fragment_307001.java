public void pressDot(View view)
{
    TextView t = (TextView) findViewById(R.id.textView);
    doot=t.toString();

    if (!doot.contains(dooot)) {
        t.append(".");
    }

}