myBigObject = myBigObject == null ? createBigObject() : myBigObject;
              ^-----------------^   ^---------------^             
           this is true the 1st time, hence that ^ is evaluated


myBigObject = myBigObject == null ?    createBigObject()     :        myBigObject;
              ^-----------------^                              
           this is false the 2nd time, hence that ^ is NOT evaluated, that ^ is