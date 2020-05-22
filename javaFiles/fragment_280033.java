org.apache.jena.rdf.model.Model model = ModelFactory.createDefaultModel();
HL7Converter hl7Segments = new HL7Converter(model);
message = "MSH|^~\\&|ADT1|MCM|LABADT|MCM|198808181126|SECURITY|ADT^A01|MSG00001-|P|2.5.1\r\n"
      + "...";

hl7Segments.ConvertToRDF(message);