RichTextItem body = (RichTextItem)doc.getFirstItem("Body");
    Vector v = body.getEmbeddedObjects();
    Enumeration e = v.elements();
    while (e.hasMoreElements()) {
      EmbeddedObject eo = (EmbeddedObject)e.nextElement();
      if (eo.getType() == EmbeddedObject.EMBED_ATTACHMENT) {
        eo.extractFile("c:\\extracts\\" + eo.getSource());
        }
    }