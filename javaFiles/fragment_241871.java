public ActivityIndicator(Context context, int theme, int type)
{
    super(context, theme);
    this.type = type;

    initialize();
}

protected void initialize()
{
    setContentView(R.layout.dialog_indicator);
    setCancelable(false);

    progress = (ImageView) findViewById(R.id.progress);
    bottomProgress = (ImageView) findViewById(R.id.bottomProgress);

    if(type == INDICATOR_BOTTOM)
    {
        progress.setVisibility(View.INVISIBLE);
    }
    else if(type == INDICATOR_SIMPLE)
    {
        bottomProgress.setVisibility(View.INVISIBLE);
    }
}