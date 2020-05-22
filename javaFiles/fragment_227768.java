public Proxy getNextElement() {    
    Iterator<Element> itr = elementsToUse.iterator();   
    if (proxiesToUse != null ){        
        while (itr.hasNext()) {         
            elementToReturn = itr.next();         
            if(usedElements.contains(elementToReturn)==false){            
               usedElements.add(elementToReturn);            
               break;         
            }       
        }   
     elementToReturn = null;
     return elementToReturn;    
    }else{      
        Proxy nextElementToReturn = getNextProxy();      
        return nextElementToReturn;    
  } 
}