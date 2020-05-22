@XmlElement(name="EntityTwo")
@XmlNullPolicy(emptyNodeRepresentsNull=true,
              nullRepresentationForXml=XmlMarshalNullRepresentation.EMPTY_NODE)
public Entity getEntityTwo() {
    return entityTwo;
}