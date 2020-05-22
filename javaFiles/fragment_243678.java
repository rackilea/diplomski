TokenStream ts= analyzer.tokenStream("myfield", reader);
            // The Analyzer class will construct the Tokenizer, TokenFilter(s), and CharFilter(s),
            //   and pass the resulting Reader to the Tokenizer.
            OffsetAttribute offsetAtt = ts.addAttribute(OffsetAttribute.class);
            CharTermAttribute charTermAttribute = ts.addAttribute(CharTermAttribute.class);

            try {
                ts.reset(); // Resets this stream to the beginning. (Required)
                while (ts.incrementToken()) {
                    // Use AttributeSource.reflectAsString(boolean)
                    // for token stream debugging.
                    System.out.println("token: " + ts.reflectAsString(true));
                    String term = charTermAttribute.toString();
                    System.out.println(term);

                }
                ts.end();   // Perform end-of-stream operations, e.g. set the final offset.
            } finally {
                ts.close(); // Release resources associated with this stream.
            }