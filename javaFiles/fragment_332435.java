public Template getTemplate(String name, String  encoding)
            throws ResourceNotFoundException, ParseErrorException
        {
            requireInitialization();

            return (Template)
                    resourceManager.getResource(name,
                        ResourceManager.RESOURCE_TEMPLATE, encoding);
        }



 private void requireInitialization()
    {
        if (!initialized)
        {
            try
            {
                init();
            }
            catch (Exception e)
            {
                getLog().error("Could not auto-initialize Velocity", e);
                throw new RuntimeException("Velocity could not be initialized!", e);
            }
        }
    }