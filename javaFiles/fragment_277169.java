try
    {
        DOMSource domSource = new DOMSource(request);
        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.transform(domSource, result);

        String checkpayload = writer.toString();
        System.out.print(checkpayload);
    }
    catch(TransformerException ex)
    {
        ex.printStackTrace();
    }
}