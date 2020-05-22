final Node<K,V>[]  [More ...] resize() {      
         Node<K,V>[] oldTab = table;  
         int oldCap = (oldTab == null) ? 0 : oldTab.length;
         int oldThr = threshold;
         int newCap, newThr = 0;   
         if (oldCap > 0) {   
             if (oldCap >= MAXIMUM_CAPACITY) {   
                 threshold = Integer.MAX_VALUE;   
                 return oldTab;    
             }    
             else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&   
                      oldCap >= DEFAULT_INITIAL_CAPACITY)    
                 newThr = oldThr << 1; // double threshold    
         }    
         else if (oldThr > 0) // initial capacity was placed in threshold    
             newCap = oldThr;
         ...
         // The capacity of the inner data structure is doubled
         Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
         table = newTab;
         ...