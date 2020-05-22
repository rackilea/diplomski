if (count == 0) 
    {
    System.out.println("Pop operation failed. "+ "The stack is empty.");
    }

    result = top.getElement();  //NPE here perhaps
    top = top.getNext();  
    count--;
    System.out.println("The element that we have poped is :" + result);
    return result;