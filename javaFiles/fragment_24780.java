public void onClick(View v) {
    Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

    switch(v.getId())
    {
        case R.id.action_bar:
            intent.putExtra("url", "http://techcrunch.com/tag/rss/");
            startActivity(intent);
            break;

        case R.id.action_bar_spinner:
            intent.putExtra("url", "http://www.bestchance.org.au/");
            startActivity(intent);
            break;

        default:
            break;
    }
}