public void myVarargsMethod(MyObject... objects) {
    if (objects.length() == 0) {

         // No parameters passed to the method...

    } else {

         for(MyObject mo : objects) {
            if (mo==null) {
                // Process null value ...
            } else {
                // Process MyObject instance...
            }
         }

    }
}