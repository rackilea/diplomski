public static SpannableStringBuilder getSpannable ( String content )
{
    SpannableStringBuilder s = new SpannableStringBuilder ( content );

    String startAt = "<em>";
    String endAt   = "</em>";

    Matcher m = Pattern.compile ( startAt + "(.*?)" + endAt ).matcher ( content );

    int counter = 0, length  = startAt.length() + endAt.length();
    int startA, startB, endA, endB;

    while ( m.find () )
    {
        startA = m.start()-counter;
        endA   = m.end(1)-counter;
        startB = m.start(1)-counter;
        endB   = m.end()-counter;

        s.setSpan ( new BackgroundColorSpan ( R.color.colorItalic ), startB, endA, 0 );
        s.replace ( endA, endB, "" );
        s.replace ( startA, startB, "" );

        counter += length;
    }

    return s;
}