package it.condarelli.javafx.dialog;

import it.condarelli.javafx.dialog.FXDialog.Callable;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import org.tbee.javafx.scene.layout.MigPane;
//import it.condarelli.javafx.validation.ValidationUtils;

/**
 * Class used to demonstrate all of the custom dialogs types' behaviour
 * 
 * @author Mauro Condarelli
 *
 */
public class TestMain extends Application {

    /**
     * Method used to demonstrate the working of MessageDialogs, InputDialogs,
     * and ConfirmDialogs
     */
    public void start1() {
        FXDialog.showMessageDialog("This is a demonstration of Information message \ndialog.", "Title (INFORMATION)", FXDialog.Severity.INFORMATION);
        FXDialog.showMessageDialog("This is a demonstration of Warning message \ndialog.", "Title (WARNING)", FXDialog.Severity.WARNING);
        FXDialog.showMessageDialog("This is a demonstration of Error message \ndialog.", "Title (ERROR)", FXDialog.Severity.ERROR);
        String input = FXDialog.showInputDialog("Enter your favorite number:", "Title (INPUT)");
        System.out.println(input);

        boolean confirm = FXDialog.showConfirmDialog("Do you really want to delete the selected item?", "Title (DELETE_OPTION)", FXDialog.ButtonSet.DELETE_OPTION);
        if (confirm)
            System.out.println("Accepted!");
        else
            System.out.println("Declined!");

        confirm = FXDialog.showConfirmDialog("Do you really want to delete the selected item?", "Title (ACCEPT_DECLINE_OPTION)", FXDialog.ButtonSet.ACCEPT_DECLINE_OPTION);
        if (confirm)
            System.out.println("Accepted!");
        else
            System.out.println("Declined!");

        confirm = FXDialog.showConfirmDialog("Do you really want to delete the selected item?", "Title (YES_NO_OPTION)", FXDialog.ButtonSet.YES_NO_OPTION);
        if (confirm)
            System.out.println("Accepted!");
        else
            System.out.println("Declined!");
    }

    /**
     * Method used to demonstrate the working of a CustomDialog
     */
    public void start2() {
        FXDialog fxd;
        CheckBox cb1, cb2, cb3;
        TextField tf;
        ComboBox<String> cb;
        Boolean res;

        fxd = FXDialog.newCustomDialog("Dialog Title Here", FXDialog.Severity.WARNING);
        cb1 = fxd.addCheckBox("Simple checkbox");
        cb2 = fxd.addCheckBox("Three state checkbox");
        cb2.setAllowIndeterminate(true);
        cb2.setIndeterminate(false);
        cb3 = fxd.addCheckBox("Disabled");
        cb3.setSelected(true);
        cb3.setDisable(true);
        res = fxd.open(null);
        System.out.println("showCustomDialog returned " + res);
        System.out.println("showCustomDialog returned " + res + "(" + (cb1.isSelected() ? "X" : " ") + ")");

        fxd = FXDialog.newCustomDialog("Dialog Title Here", FXDialog.Severity.WARNING);
        cb1 = fxd.addCheckBox("Simple checkbox");
        cb2 = fxd.addCheckBox("Three state checkbox");
        cb2.setAllowIndeterminate(true);
        cb2.setIndeterminate(false);
        cb3 = fxd.addCheckBox("Disabled");
        cb3.setSelected(true);
        cb3.setDisable(true);
        res = fxd.open(FXDialog.ButtonSet.ACCEPT_DECLINE_OPTION);
        System.out.println("showCustomDialog returned " + res + "(" + (cb1.isSelected() ? "X" : " ") + ")");

        fxd = FXDialog.newCustomDialog("Dialog Title Here", FXDialog.Severity.INFORMATION);
        tf = fxd.addTextField("Name:");
//      ValidationUtils.install(tf, ValidationUtils.getDoubleValidator());
        cb = fxd.addComboBox("Type:", FXCollections.observableArrayList("pippo", "pluto", "paperino"));
//      ValidationUtils.install(cb, ValidationUtils.getComboBoxValidator());
        res = fxd.open(null);
        System.out.println("showCustomDialog returned " + res);
        if (res) {
            System.out.println("   '" + tf.getText() + "'");
            System.out.println("   '" + cb.getValue() + "'");
        }

        fxd = FXDialog.newCustomDialog("Dialog Title Here", FXDialog.Severity.INFORMATION);
        tf = fxd.addTextField("Name:");
//      ValidationUtils.install(tf, ValidationUtils.getIntegerValidator());
        cb = fxd.addComboBox("Type:", FXCollections.observableArrayList("pippo", "pluto", "paperino"));
//      ValidationUtils.install(cb, ValidationUtils.getComboBoxValidator());
        fxd.addAction("do it", new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("handler has been called ("+input+")");
                return null;
            }
        });
        res = fxd.open(FXDialog.ButtonSet.OK_CANCEL_OPTION);
        System.out.println("showCustomDialog returned " + res);
        if (res) {
            System.out.println("   '" + tf.getText() + "'");
            System.out.println("   '" + cb.getValue() + "'");
        }
    }

    /**
     * Method that adds two buttons to the primary stage, each one dedicated to
     * launch a demo on some type of custom dialogs.
     * 
     * @param primaryStage
     *            : the primary Stage for this Application
     */
    private void init(Stage primaryStage) {

        MigPane root = new MigPane("wrap 1", "[fill]");

        primaryStage.setScene(new Scene(root));

        // String insetTextCss =
        // getClass().getResource("InsetTextButton.css").toExternalForm();

        Button b1 = new Button("Some simple Dialogs");
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                start1();
            }
        });
        root.add(b1);
        Button b2 = new Button("Some more complex Dialogs");
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                start2();
            }
        });
        root.add(b2);

    }

    @Override
    public void start(Stage primaryStage) {
        init(primaryStage);
        primaryStage.show();
    }

    /**
     * Main function.
     * 
     * @param args
     *            : the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}