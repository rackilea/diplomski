if( token instanceof PDFOperator )
            {
                PDFOperator op = (PDFOperator)token;
                if( op.getOperation().equals( "Do") )
                {
                    //remove the one argument to this operator
                    COSName name = (COSName)newTokens.remove( newTokens.size() -1 );
                    continue;
                }
                else if (PAINTING_PATH_OPS.contains(op.getOperation()))
                {
                    // replace path painting operator by path no-op
                    token = PDFOperator.getOperator("n");
                }
            }