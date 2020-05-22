Object obj; // don't new Object() here as we will only write over it

if(value == 1){
    obj = something();
} elseif (value == 2){
    obj = something();
} else {
   throw new ApplicationException();
}

useTheObject(obj);