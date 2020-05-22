case XA_POOL: {
                        if (! isXa) throw new ParserException(bundle.unexpectedElement(CommonConnDef.Tag.XA_POOL.name()));
                        if (poolDefined)
                            throw new ParserException(bundle.multiplePools());
                        parseXaPool(reader, connectionDefinitionNode);
                        poolDefined = true;
                        break;
                    }
                    case POOL: {
                        if (isXa) throw new ParserException(bundle.unexpectedElement(CommonConnDef.Tag.POOL.name()));
                        if (poolDefined)
                            throw new ParserException(bundle.multiplePools());
                        parsePool(reader, connectionDefinitionNode);
                        poolDefined = true;
                        break;
                    }