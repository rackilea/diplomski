package bht.tools.util.upd;

import java.awt.Window;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javax.swing.JDialog;

/**
 * TestDialog is copyright Blue Husky Programming ©2014 GPLv3 <hr/>
 * 
 * @author Kyli of Blue Husky Programming
 * @version 1.0.0
 *      - 2014-09-30 (1.0.0) - Kyli created TestDialog
 * @since 2014-09-30
 */
public class TestDialog extends JDialog
{
    public TestDialog(Window owner)
    {
        super(owner);
        initGUI();
    }

    private JFXPanel holder;
    private Scene interior;
    private ProgressBar progressBar;
    private GridPane root;
    private void initGUI()
    {
        holder = new JFXPanel();
        setContentPane(holder);
        Platform.runLater( () -> initJFXPanel(holder) );
        pack();
    }

    private void initJFXPanel(JFXPanel holder) {
        root = new GridPane();
        interior = holder.getScene();
        if (interior == null)
            holder.setScene(interior = new Scene(root));
        interior.setRoot(root);
        progressBar = new ProgressBar();
        progressBar.setProgress(-1);
        root.add(progressBar, 0, 1);
    }

    public static void main(String[] args)
    {
        new TestDialog(null).setVisible(true);
    }
}