boolean doSomething = true;
        for(int i = 0; i < num && doSomething; i++) {
            if(elementiInseriti[j] < elementiInseriti[i]) {  
               doSomething = false;
            }
        }
        if (doSomething)
            // do something