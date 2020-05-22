if(aTree[0]==0){
    aTree[0]=key;
}

boolean add = false;
int curIdx=0;

while(!add){ // add is false so the loop is entered
    if(key<aTree[curIdx]){ // aTree[curIdx] == key so false

    }else{
        if(aTree[curIdx*2+2]==0){ // true because arrays are initialized
                                  // with all elements 0

            aTree[curIdx*2+2]= key; // assign key a second time
            add=true;
        }
    }
}