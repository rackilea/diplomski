public void addSubElement (Node<?> node){ 
      Class<E> expectedChildType = getChildType();
      if (expectedChildType.isAssignableFrom(node.getClass())){//if node instanceOf E
         subElements.add(expectedChildType.cast(node)); 
      }
      else throw new ClassCastException("A non-expected child was intended to add to this "+this.getClass().getSimpleName()+" element");
 }