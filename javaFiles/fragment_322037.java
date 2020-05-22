for(int i = 0; i < arr.size(); i++){
    if (arr.get(i).getName().equals(nameInput)) {
          Arr obj = arr.remove(i); // remove the item by index     
          System.out.println(obj);  // print the object             
          break;  // terminate the loop iteration
     }
}