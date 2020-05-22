Object biggestObject = array[0];
    for (Object obj: array){
        if (biggestObject.compareTo(obj) == 1){
            biggestObject = obj;
        }
    }
 return biggestObject;