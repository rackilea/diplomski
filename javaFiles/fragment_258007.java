public room A = new room();
public room B = new room();

{ // this is the start of an "instance initializer"; it runs before any constructors (but after field initializers)
    // if you have a constructor, you could choose to put this in the constructor instead; personal preference
    A.addItem(new door(B));
    B.addItem(new door(A));
}