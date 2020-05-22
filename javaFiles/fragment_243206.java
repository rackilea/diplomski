public static Widgets load(File file) 
            throws JAXBException, IOException
    {
        Reader reader =
            new WidgetFilterReader( 
                     "<colors>([^<>]+?)\\s*<\\/colors>", "<color>|</color>",
                new FileReader(file));
        try
        {
            JAXBContext ctx = JAXBContext.newInstance(Widgets.class);
            Unmarshaller u = ctx.createUnmarshaller();
            return (Widgets) u.unmarshal(reader);
        }
        finally
        {
            reader.close();
        }
    }