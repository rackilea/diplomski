public class MyClass {
    private Engine graph;

    public MyClass(){
        graph = new Engine();
        graph.addNode("Aberdeen", 391, 807);
        graph.addNode("Blackpool", 331, 434);
        graph.addNode("Bristol", 358, 173);
        graph.addNode("Cardiff", 319, 174);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:

        //graph.gatherData();
    }  

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
         /* Set the Nimbus look and feel */

        //Create instance of your class (im assuming your jframe?)
        new MyClass();
    }
}