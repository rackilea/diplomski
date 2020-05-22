@Override
    public void serialize(
      Prodotto prod, JsonGenerator jgen, SerializerProvider serializer) throws IOException {
        jgen.writeStartObject();

//      getPeso_netto returns an Integer, that in the example is null
        if (prod.getPeso_netto() != null)
            jgen.writeNumberField("peso_netto", prod.getPeso_netto());
        else {
            jgen.writeNullField("peso_netto");     
        }