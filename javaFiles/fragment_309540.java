public class Windows extends JFrame{
public Windows(){
    setTitle("Converter");       
    setSize(null);
    JTabbedPane tabby = new JTabbedPane();
    getContentPane().add(tabby);
    Temperature t = new Temperature();
    tabby.addTab(t);
}