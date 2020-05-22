MbMessage inMessage = inAssembly.getMessage();
MbElement comIbmAggregateReplyBody = inMessage.getRootElement().getFirstElementByPath("/ComIbmAggregateReplyBody");
MbElement docGenBefa = comIbmAggregateReplyBody.getFirstElementByPath("/ComIbmAggregateReplyBody/DocGenBefa");
MbElement docGenBefaXML = docGenBefa.getLastChild();
MbElement docGenBefbDocData = docGenBefaXML.getLastChild();
Node docGenBefaNode = docGenBefbDocData.getDOMNode();
JAXBElement<BefpDocData> inMsgJavaObj = jaxbContext.createUnmarshaller().unmarshal(docGenBefaNode, BefpDocData.class);
BefpDocData data = inMsgJavaObj.getValue();