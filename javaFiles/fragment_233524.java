class MyTest extends GuiTest {
     public Parent getRootNode() {
         HelloWorld app = new HelloWorld();
         return app.getRoot(); // the root StackPane with button
     }
 }