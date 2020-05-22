public class Nodo {
  String id;
  ArrayList<Nodo> children = new ArrayList<>();
}

public class NodoConverter implements Converter {


  /** {@inheritDoc} */
  @Override
  public boolean canConvert(Class arg0) {
    return arg0.equals(Nodo.class);
  }

  /** {@inheritDoc} */
  @Override
  public void marshal(Object arg0, HierarchicalStreamWriter writer, MarshallingContext arg2) {
    marshal((Nodo) arg0, writer, arg2, "nodo");
  }

  private void marshal(Nodo nodo, HierarchicalStreamWriter writer, MarshallingContext ctx, String elname) {
    writer.addAttribute("id", nodo.getId());
    for (Nodo child : nodo.children) {
      writer.startNode("child");
      ctx.convertAnother(child);
      writer.endNode();
    }
  }

  /** {@inheritDoc} */
  @Override
  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext ctx) {
    Nodo nodo = new Nodo();
    nodo.setId(reader.getAttribute("id"));
    while (reader.hasMoreChildren()) {
      reader.moveDown();
      Nodo child = (Nodo) ctx.convertAnother(nodo, Nodo.class);
      nodo.children.add(child);
      reader.moveUp();
    }
  }

}