public void delete(int k){
  //instance variable
  Node current = head;

  if(current == null || current.next == null){ //check if list is empty

      throw new NullPointerException();
      }

  if (k < 0 || k >= size()){                  // check if k is out of bounds

      throw new IndexOutOfBoundsException();
      }

  if (k == 0){                                // this handles k = 0 condition
      head = head.next;
  }

  else

  for (int i = 0; i < k-1; i++){              // otherwise, if K != 0,
      current = current.next;                 // move pointer to k position

  }

  if (current != null) {
        current.next = current.next.next;
  }

  N--;  

  }