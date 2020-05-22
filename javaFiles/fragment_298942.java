@Provider
@Consumes( "application/xml" )
public class MyLazyMessageBodyReader implements MessageBodyReader<Object> {
  @Context
  private Providers ps;

  private MessageBodyReader<Object> reader;

  @Override
  public final Object readFrom(
          Class<Object> type,
          Type type1,
          Annotation[] antns,
          MediaType mt,
          MultivaluedMap<String, String> mm,
          InputStream in)
          throws IOException, WebApplicationException
  {
    return this.getLazyReader().readFrom(type, type1, antns, mt, mm, in);
  }

  private MessageBodyReader<Object> getLazyReader() {
    if (this.reader == null) {
      this.reader = new MyMessageBodyReader(this.ps);
    }
    return this.reader;
  }
}

public class MyMessageBodyReader implements MessageBodyReader<Object> {
   public MyMessageBodyReader(Providers ps) {
      // try to do something with ps here
      // e.g. pass to a superclass constructor,
      // as required by the solution in the other thread
   }

   [...] // implemented interface methods
}