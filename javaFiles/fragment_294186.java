import javax.xml.transform.Source;
        import javax.xml.transform.TransformerException;
        import javax.xml.transform.URIResolver;
        import javax.xml.transform.stream.StreamSource;

        public class CachedURIResolver implements URIResolver
          {
            @Override
            public Source resolve (final String href, final String base) 
              throws TransformerException 
              {
                // TODO: caching logic 
                return new StreamSource(href);
              }
          }

        ...

        final Transformer transformer = transformerFactory.newTransformer(transformation); 
        transformer.setURIResolver(new CachedURIResolver());