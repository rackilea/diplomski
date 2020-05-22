class Parent {

  private Collection<Child> children;

  //note the default accessibility modifiers
  void addChild(Child) {
    children.add(child);
  }

  void removeChild(Child) {
    children.remove(child);
  }
}

class Child {

   private Parent parent;
   public void setParent(Parent parent){
     if (this.parent != null)
       this.parent.removeChild(this);
     this.parent = parent;
     this.parent.addChild(this);
   }
}