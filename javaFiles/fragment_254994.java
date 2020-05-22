@Component("mainForm")
public class NewJFrame extends javax.swing.JFrame {

    @Autowired
    FileProcessor fileProcessor;

    @Autowired
    ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    MyDirectoryReader myDirectoryReader;

    @Autowired
    AuthThread authThread;


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        taskExecutor.execute(new Runnable() {

           @Override
           public void run() {
              ...
              authSuccessfull = authThread.auth();
              ...
           }
    });
}