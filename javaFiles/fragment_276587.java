while ( !classPath.delete(..) && count < 10){
      Thread.wait(50);
      count++
    }

    if (count == 10) 
         Throw Exception