@FacesComponent("MyComponent")
public class MyComponent 
    extends UIComponentBase 
    implements NamingContainer {

  @Override public String getFamily() { 
    return UINamingContainer.COMPONENT_FAMILY; 
  }

  @Override public boolean getRendersChildren() { return true; }

  @Override public void encodeChildren(FacesContext fc) throws IOException {
    StringWriter writer = new StringWriter();
    ResponseWriter rw = fc.getResponseWriter();

    // create the response writer
    ResponseWriter replacement = rw.cloneWithWriter(writer);

    // this tag wrapping step is necessary for the MyFaces ResponseWriter to 
    // work correctly
    replacement.startDocument();
    replacement.startElement("div", this);

    // mask the response writer temporarily    
    fc.setResponseWriter(replacement);

    // perform the render to get the text in our string
    super.encodeChildren(fc);

    // unmask the response writer
    fc.setResponseWriter(rw);

    // finish the wrapping calls
    replacement.endElement("div");
    replacement.endDocument();

    // this strips the rendered <div> tag wrapper from the generated text.
    final String renderedText = writer.toString()
            .substring(5, writer.toString().length()-6);

    // process the text and send it out
    rw.append(Formatter.format(renderedText));
  }
}