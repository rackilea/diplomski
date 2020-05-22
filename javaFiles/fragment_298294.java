private List<Foto> foto = ...;

@XmlAnyElement
public List<JAXBElement<Foto>> getFoto() {
List<JAXBElement<Foto>> elements = new ArrayList<JAXBElement<Foto>>();
for (Foto current : foto ) 
    elements.add(new JAXBElement(new QName("foto_" + current.getValue(), 
                                 Foto.class, current);
return elements;
}