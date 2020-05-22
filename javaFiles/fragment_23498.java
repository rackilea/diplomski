public class BTCEURTradeMessageBodyReader 
        implements MessageBodyReader<BTCEURTrades> {

  final org.slf4j.Logger logger = 
          LoggerFactory.getLogger(BTCEURTradeMessageBodyReader.class);

  @Override
  public boolean isReadable(Class<?> type, Type genericType, 
          Annotation[] annotations, MediaType mediaType) {
    logger.info("isReadable being checked for: {} and media type: {}", type, mediaType);
    return type == BTCEURTrades.class;
  }

  @Override
  public BTCEURTrades readFrom(Class<BTCEURTrades> type, Type genericType, 
          Annotation[] annotations, MediaType mediaType, 
          MultivaluedMap<String, String> httpHeaders, InputStream entityStream) 
          throws IOException, WebApplicationException {
    logger.info("readFrom being called for: {}", type);

    BTCEURTrades btceurTrades;
    try {
      btceurTrades = new Genson().deserialize(entityStream, type);
    } catch(Exception e) {
      logger.error("Error processing JSON reponse.", e);
      throw new ProcessingException("Error processing JSON reponse.");
    }
    return btceurTrades;
  }

}