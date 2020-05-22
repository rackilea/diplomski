// create JAXBContext for the primer.xsd
        JAXBContext context = JAXBContext.newInstance("primer");

        Unmarshaller unmarshaller = context.createUnmarshaller();

        // purchase order notification callback
        final PurchaseOrders.Listener orderListener = new PurchaseOrders.Listener() {
            public void handlePurchaseOrder(PurchaseOrders purchaseOrders, PurchaseOrderType purchaseOrder) {
                System.out.println("this order will be shipped to "
                        + purchaseOrder.getShipTo().getName());
            }
        };

        // install the callback on all PurchaseOrders instances
        unmarshaller.setListener(new Unmarshaller.Listener() {
            public void beforeUnmarshal(Object target, Object parent) {
                if(target instanceof PurchaseOrders) {
                    ((PurchaseOrders)target).setPurchaseOrderListener(orderListener);
                }
            }

            public void afterUnmarshal(Object target, Object parent) {
                if(target instanceof PurchaseOrders) {
                    ((PurchaseOrders)target).setPurchaseOrderListener(null);
                }
            }
        });

        // create a new XML parser
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XMLReader reader = factory.newSAXParser().getXMLReader();
        reader.setContentHandler(unmarshaller.getUnmarshallerHandler());

        for (String arg : args) {
            // parse all the documents specified via the command line.
            // note that XMLReader expects an URL, not a file name.
            // so we need conversion.
            reader.parse(new File(arg).toURI().toString());
        }
    }
}