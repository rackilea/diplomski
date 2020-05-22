System.out.format(...)
System.out.printf(...)
System.out.print(String.format(...)) // you will need to include the line break in the format
System.out.println(String.format(...)) // line break will be caused by println()
import static java.lang.String.format;
System.out.print(format(...))
System.out.println(format(...))
System.out.println(new Formatter().format(...))