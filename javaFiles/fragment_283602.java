//loop for each index within basket
      for (int indexBasket=0; indexBasket<basket.size(); indexBasket++){

        //if value at index = what we want to remove
       if (basket.get(indexBasket).equals(remove))

              {
       //then assign the value of posistion in the array to targetIndex
               targetIndex = indexBasket;
              }

          }
       }

  //return targetIndex
  return targetIndex;
}