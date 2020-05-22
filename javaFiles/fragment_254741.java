Node elem = null;
    NodeList lista=doc.getElementsByTagName("Items");
                for(int i=0;i<lista.getLength();i++){
                elem = lista.item(i);
                }

                NodeList lista2=doc.getElementsByTagName("MoreOffersUrl");
                for(int i=0;i<lista2.getLength();i++){
                   Node elem2=lista2.item(i);
                    elem.removeChild(elem2);
                }