case TRANSACTION_SUPPORT: {
                         if (txSupportMatched) {
                            throw new ParserException(bundle.unexpectedElement(TRANSACTIONSUPPORT.getXmlName()));
                        }
                        String value = rawElementText(reader);
                        TRANSACTIONSUPPORT.parseAndSetParameter(value, operation, reader);
                        isXa = value != null && TransactionSupportEnum.valueOf(value) == TransactionSupportEnum.XATransaction;
                        txSupportMatched = true;
                        break;
                    }