Dequeue<animal> myQ;
 for(int i = 0; i < animalList.length; i++){
     if(animalList[i].name == "goat") myQ.push_front(animalList[i]);
     else myQ.push_back(animalList[i]);

 }