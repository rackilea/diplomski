Parser parser = new testParser(tokens);
            parser.setErrorHandler(new DefaultErrorStrategy()
    {

        @Override
        public void recover(Parser recognizer, RecognitionException e) {
            for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent()) {
                context.exception = e;
            }

            throw new ParseCancellationException(e);
        }


        @Override
        public Token recoverInline(Parser recognizer)
            throws RecognitionException
        {
            InputMismatchException e = new InputMismatchException(recognizer);
            for (ParserRuleContext context = recognizer.getContext(); context != null; context = context.getParent()) {
                context.exception = e;
            }

            throw new ParseCancellationException(e);
        }
    });

 parser.program(); //back to first rule in your grammar