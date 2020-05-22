public V call() throws Exception {

    System.out.println("Call of MyCallable invoked");
    System.out.println("Result = " + this.ci.doSomething(10, 20));
    //...
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          updateView();
        }
    });
    //...
    return (V) "Good job";
}