// Create object for r
        R r = wmlObjectFactory.createR(); 
        p.getContent().add( r); 
            // Create object for tab (wrapped in JAXBElement) 
            R.Tab rtab = wmlObjectFactory.createRTab(); 
            JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped = wmlObjectFactory.createRTab(rtab); 
            r.getContent().add( rtabWrapped); 
            // Create object for t (wrapped in JAXBElement) 
            Text text = wmlObjectFactory.createText(); 
            JAXBElement<org.docx4j.wml.Text> textWrapped = wmlObjectFactory.createRT(text); 
            r.getContent().add( textWrapped); 
                text.setValue( "4 Privet Drive"); 
            // Create object for br
            Br br = wmlObjectFactory.createBr(); 
            r.getContent().add( br); 
            // Create object for tab (wrapped in JAXBElement) 
            R.Tab rtab2 = wmlObjectFactory.createRTab(); 
            JAXBElement<org.docx4j.wml.R.Tab> rtabWrapped2 = wmlObjectFactory.createRTab(rtab2); 
            r.getContent().add( rtabWrapped2); 
            // Create object for t (wrapped in JAXBElement) 
            Text text2 = wmlObjectFactory.createText(); 
            JAXBElement<org.docx4j.wml.Text> textWrapped2 = wmlObjectFactory.createRT(text2); 
            r3.getContent().add( textWrapped2); 
                text2.setValue( "Little Whinging");