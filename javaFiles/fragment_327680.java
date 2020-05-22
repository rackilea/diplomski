public class Foo {
    @DateTimeFormat(pattern="yyyy-MMM-dd hh:mmaa")
    DateTime myJodaDateTime = ...; 
}
...
ConversionService cs = ...; // FormattingConversionService with default formatters
System.out.println(
    cs.convert(
        foo.myJodaDateTime, 
        new TypeDescriptor(Foo.class.getDeclaredField("myJodaDateTime")),
        TypeDescriptor.valueOf(String.class)
    )
);