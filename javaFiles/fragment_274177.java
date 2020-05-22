MainPanel mainPanel = MainPanel();
MyOtherComponent myOtherComponent = MyOtherComponent(); 
Something something = new Something();
something.myMethod(mainPanel.getMousePosition());
something.myMethod(myOtherComponent.myMousePositionMethod());
// or even
something.myMethod(new Point(1,1));