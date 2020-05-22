public TimePreference(Context ctxt, AttributeSet attrs, int defStyle) {
        super(ctxt, attrs, defStyle);

        setPositiveButtonText(R.string.set);
        setNegativeButtonText(R.string.cancel);
    //    calendar = new GregorianCalendar();  Modify this line as below
        calendar = new GregorianCalendar(TimeZone.getDefault(), Locale.US);
    }