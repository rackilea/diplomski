current = root;
while(current != null){
   if(value.compareTo(current.getElement())<=-1)
   {
        current = current.left_child;
   }else if(value.compareTo(current.getElement())>=1){
        current = current.right_child;
   }else{
        // Duplication
   }
}