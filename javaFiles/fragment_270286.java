package work.basil.example;

import java.time.format.DateTimeFormatter;

public enum FormatDateOnly
{
    DD_MM_YYYY( DateTimeFormatter.ofPattern( "dd.MM.uuuu" ) , "DD.MM.YYYY" ),
    YYYY_MM_DD( DateTimeFormatter.ofPattern( "uuuu.MM.dd" ) , "YYYY.MM.DD" ),
    MM_DD_YYYY( DateTimeFormatter.ofPattern( "MM.dd.uuuu" ) , "MM.DD.YYYY" );

    private DateTimeFormatter formatter;
    private String displayName;

    FormatDateOnly ( DateTimeFormatter formatter , String displayName )
    {
        this.formatter = formatter;
        this.displayName = displayName;
    }

    @Override
    public String toString ( )
    {
        return "LocalDateFormat{" +
                "displayName='" + this.displayName + '\'' +
                '}';
    }

    public DateTimeFormatter getFormatter ( )
    {
        return this.formatter;
    }

    public String getDisplayName ( )
    {
        return this.displayName;
    }
}