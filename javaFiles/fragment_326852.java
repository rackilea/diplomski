public @Nullable
    String toPdxmlString(final @NotNull Deals input) {
        try {
            final Marshaller marshaller = jaxbContext.createMarshaller();
            final DateFormatterAdapter dateFormatterAdapter = new DateFormatterAdapter(PdxmlDateTimeUtil.FXONLINE_DEFAULT_DEAL_TIMEZONE);
            marshaller.setAdapter(Adapter2.class, dateFormatterAdapter);
            StringWriter writer = new StringWriter();
            marshaller.marshal(input, writer);
            return writer.toString();
        } catch (JAXBException exception) {
            LOGGER.error("Unable to marshall the given input Deals: {}, into String using JAXB Context: {}, ... ", input, jaxbContext, exception);
        }
        return null;
    }