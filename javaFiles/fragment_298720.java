public void read(String key, String value) 
    {
        try (FileReader fReader = new FileReader(inputFile); FileWriter fWriter = new FileWriter(outputFile))
        {
            XMLEventFactory factory = XMLEventFactory.newInstance();
            XMLEventReader reader = XMLInputFactory.newFactory().createXMLEventReader(fReader);
            XMLEventWriter writer = XMLOutputFactory.newFactory().createXMLEventWriter(fWriter);

            while (reader.hasNext())
            {
                XMLEvent event = reader.nextEvent();
                boolean update = false;

                if (event.isStartElement() && event.asStartElement().getName().getLocalPart().equals(key))
                {
                        update = true;
                }
                else if (event.isCharacters() && update)
                {
                        Characters characters = factory.createCharacters(value);
                        event = characters;
                        update = false;
                }
                writer.add(event);
            }
        }
        catch (XMLStreamException | FactoryConfigurationError | IOException e)
        {
            e.printStackTrace();
        }

    }