/**
   * Returns a String version of this.
   *
   * @return  A String description of this.
   */
  public String toString(){
    String string = "";
    DoubleNode<E> current = this.head;
    string += stringHelper(this.head);
    return string;
  }
  //Helps the full to string method
  private String stringHelper(DoubleNode<E> node){
    String string = "";
    if(node == null){
      return string;
    }
    string+= node.getValue();
    string+= ", ";
    node = node.getNextLink();
    if(node == this.head){
      return string;
    }
    else{
      string += node.getValue();
      return (string + ", " + stringHelper(node.getNextLink()));
    }
  }