package it.condarelli.javafx.dialog;

import java.io.File;
import java.net.MalformedURLException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import jidefx.scene.control.decoration.DecorationPane;
//import jidefx.scene.control.validation.ValidationEvent;
import net.miginfocom.layout.CC;
import net.miginfocom.layout.LC;

import org.tbee.javafx.scene.layout.MigPane;

import it.condarelli.javafx.css.StyleManager;
//import it.condarelli.javafx.validation.ValidationUtils;

public class FXDialog {

    private ImageView               icon;
    private Label                   lblHeader;
    private Label                   lblMsg;

    private Button                  btnAccept;
    private Button                  btnDecline;
    private Button                  btnCancel;

    private TextField               inputField;
    private CheckBox                ckbAction;

    private MigPane                 root;
    private Response                response;

    protected Stage                 primaryStage;
    private MigPane                 pneButtons;

    private MigPane                 pneCustom;

    /**
     * protected enum used to model a user's choice in confirmation dialogs
     */
    protected enum Response {
        APPROVE(true), DECLINE(false), CANCEL(null);
        private Boolean val;

        private Response(Boolean val) {
            this.val = val;
        }

        public Boolean getValue() {
            return val;
        }
    }

    public enum ButtonSet {
        DELETE_OPTION(), YES_NO_OPTION(), YES_NO_CANCEL_OPTION(), ACCEPT_DECLINE_OPTION(), OK_OPTION(), OK_CANCEL_OPTION();
    }

    public enum Type {
        CONFIRMATION, INPUT, MESSAGE, CUSTOM;
    }

    public enum Severity {
        ERROR("error.png", "-fx-background-color: red;"), INFORMATION("information.png", "-fx-background-color: blue;"), WARNING("warning.png", "-fx-background-color: orange;"), QUESTION(
                "question64.png", "-fx-background-color: gold;");
        private String  ico;
        private String  css;

        private Severity(String ico, String css) {
            this.ico = ico;
            this.css = css;
        }

        /**
         * Returns the textual filename of a specific image file that has to be
         * displayed as an icon for a certain Severity value
         * 
         * @return the textual icon-filename
         */
        protected String getIcon() {
            return ico;
        }

        /**
         * Returns the textual css info for a certain Severity value
         * 
         * @return the textual icon-filename
         */
        protected String getCss() {
            return css;
        }
    }

    private double  initX;  // X-Coordinate location of the dialog
    private double  initY;  // Y-Coordinate location of the dialog

    // inits this object with a modal stage
    protected FXDialog(Type type, String header, String message) {
        primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        MigPane inner = new MigPane(/*"debug"*/);
        lblHeader = new Label(header);
        lblHeader.getStyleClass().add("fxdialog-header");
        inner.add(lblHeader, "dock north, gaptop 7, gapbottom 5");
        icon = new ImageView(/*new Image(FXDialog.class.getResource("icons/question64.png").toExternalForm())*/);
        inner.add(icon, "dock west, gapright 5");
        if (message != null) {
            lblMsg = new Label(message);
            lblMsg.getStyleClass().add("fxdialog-message");
            inner.add(lblMsg, "wrap");
        }
        switch (type) {
        case CONFIRMATION:
            break;
        case CUSTOM:
            pneCustom = new MigPane(new LC()/* .debug() */);
//          inner.add(new DecorationPane(pneCustom));
            inner.add(pneCustom);
            break;
        case INPUT:
            pneCustom = new MigPane(new LC()/* .debug() */);
            inputField = new TextField();
            pneCustom.add(inputField);
            inner.add(pneCustom);
            break;
        case MESSAGE:
            break;
        }
        pneButtons = new MigPane(new LC().align("right", "center"));
        inner.add(pneButtons, "dock south");

        DropShadow ds = new DropShadow();
        ds.setHeight(25);
        ds.setRadius(12);
        ds.setWidth(25);
        inner.setEffect(ds);
        inner.getStyleClass().add("fxdialog");

        root = new MigPane();
        root.getStyleClass().add("fxdialog-root");
        //root.setStyle("-fx-background-color: transparent;");
        root.add(inner);
        // root.setStyle("-fx-effect: dropshadow(one-pass-box, #000, 10, 1.0, 0, 0);");

        //root.getStylesheets().add(getClass().getResource("FXDialog.css").toExternalForm());
        StyleManager.add("FXDialog", getClass().getResource("FXDialog.css").toExternalForm());
        StyleManager.register("FXDialog", root);
        primaryStage.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                case ENTER:
                    if (btnAccept != null)
                        btnAccept.fire();
                    break;
                case ESCAPE:
                    if (btnDecline != null)
                        btnDecline.fire();
                    break;
                default:
                    // do nothing
                }
            }
        });

    }

    protected void setButtons(ButtonSet buttonSet) {
        setButtons(buttonSet, null);
    }

    protected void setButtons(ButtonSet buttonSet, String cbLabel) {
        if (buttonSet == null)
            buttonSet = ButtonSet.OK_OPTION;
        switch (buttonSet) {
        case DELETE_OPTION:
            btnAccept = new Button("Delete");
            btnAccept.setPrefWidth(70.0);
            btnDecline = new Button("Don't Delete");
            btnDecline.setDefaultButton(true);
            btnDecline.requestFocus();
            btnDecline.setPrefWidth(80.0);
            break;
        case YES_NO_OPTION:
            btnAccept = new Button("Yes");
            btnAccept.setPrefWidth(70.0);
            btnAccept.setDefaultButton(true);
            btnAccept.requestFocus();
            btnDecline = new Button("No");
            btnDecline.setPrefWidth(70.0);
            break;
        case OK_CANCEL_OPTION:
            btnAccept = new Button("Ok");
            btnAccept.setPrefWidth(70.0);
            btnAccept.setDefaultButton(true);
            btnAccept.requestFocus();
            btnDecline = new Button("Cancel");
            btnDecline.setPrefWidth(70.0);
            break;
        case YES_NO_CANCEL_OPTION:
            btnAccept = new Button("Yes");
            btnAccept.setPrefWidth(70.0);
            btnAccept.setDefaultButton(true);
            btnAccept.requestFocus();
            btnDecline = new Button("No");
            btnDecline.setPrefWidth(70.0);
            btnCancel = new Button("Cancel");
            btnCancel.setPrefWidth(70.0);
            break;
        case ACCEPT_DECLINE_OPTION:
            btnAccept = new Button("Accept");
            btnAccept.setPrefWidth(80.0);
            btnAccept.setDefaultButton(true);
            btnAccept.requestFocus();
            btnDecline = new Button("Decline");
            btnDecline.setPrefWidth(80.0);
            break;
        case OK_OPTION:
        default:
            btnAccept = new Button("Ok");
            btnAccept.setPrefWidth(70.0);
            btnAccept.setDefaultButton(true);
            btnAccept.requestFocus();
        }
        if (cbLabel != null) {
            ckbAction = new CheckBox(cbLabel);
            pneButtons.add(ckbAction, "tag left");
        }
        if (btnCancel != null) {
            btnCancel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setReponse(Response.CANCEL);
                    primaryStage.close();
                }
            });
            pneButtons.add(btnCancel, "tag cancel");
        }
        if (btnDecline != null) {
            btnDecline.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setReponse(Response.DECLINE);
                    primaryStage.close();
                }
            });
            pneButtons.add(btnDecline, "tag no");
        }
        if (btnAccept != null) {
            btnAccept.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    setReponse(Response.APPROVE);
                    if (cbAction != null && ckbAction.isSelected()) {
                        String value = (inputField != null) ? inputField.getText() : null;
                        rtnObject = cbAction.doit(value);
                    }

                    primaryStage.close();
                }
            });
            pneButtons.add(btnAccept, "tag yes");
        }
    }

    private Boolean open() {
        Scene scene = new Scene(root, Color.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                initX = me.getScreenX() - primaryStage.getX();
                initY = me.getScreenY() - primaryStage.getY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                primaryStage.setX(me.getScreenX() - initX);
                primaryStage.setY(me.getScreenY() - initY);
            }
        });
//      ValidationUtils.initialize(pneCustom);
        primaryStage.showAndWait();
        StyleManager.unregister(root);
        return response.getValue();
    }

    /**
     * The purpose of this method is to retain the selected action in the
     * confirmation dialog.
     * 
     * @param response
     */
    protected void setReponse(Response response) {
        this.response = response;
    }

    /**
     * Static method responsible for the displaying of a customizable message
     * box.
     * 
     * @param message
     *            : the actual message to display in the message box
     * @param title
     *            : the title of the message dialog
     * @param messageType
     *            : available message types are: INFORMATION, WARNING, ERROR,
     *            each one with its graphical style
     */
    public static void showMessageDialog(String message, String title) {
        showMessageDialog(message, title, Severity.INFORMATION);
    }

    public static void showMessageDialog(String message, String title, Severity severity) {
        FXDialog dialog = new FXDialog(Type.MESSAGE, title, message);

        dialog.setKind(severity);
        dialog.setButtons(ButtonSet.OK_OPTION);

        dialog.open();
    }

    protected void setKind(Severity severity) {
        icon.setImage(new Image(FXDialog.class.getResource("icons/" + severity.getIcon()).toExternalForm()));
        //lblHeader.setStyle(severity.getCss());
        for (Severity s : Severity.values())
            root.getStyleClass().remove(s.name());
        root.getStyleClass().add(severity.name());
    }

    /**
     * Static method responsible for the displaying of a dialog box with custom
     * FX content.
     * 
     * @param content
     *            : a Region representing the content to be added to the dialog
     *            stage
     * @param title
     *            : the title of the dialog
     * @param messageType
     *            : available message types are: INFORMATION, WARNING, ERROR,
     *            each one with its graphical style
     * @return
     */
    public static Boolean showCustomDialog(Region content, String title) {
        return showCustomDialog(content, title, Severity.QUESTION);
    }

    public static Boolean showCustomDialog(Region content, String title, Severity severity) {
        return showCustomDialog(content, title, severity, ButtonSet.ACCEPT_DECLINE_OPTION);
    }

    public static Boolean showCustomDialog(Region content, String title, Severity severity, ButtonSet buttonSet) {
        FXDialog dialog = newCustomDialog(content, title, null, null, severity, buttonSet);
        return dialog.open();
    }

    private static FXDialog newCustomDialog(Region content, String title, String prompt, Callable<?> action, Severity severity, ButtonSet buttonSet) {
        final FXDialog dialog = new FXDialog(Type.CUSTOM, title, null);

        dialog.setKind(severity);
        dialog.setButtons(buttonSet, prompt);

        content.styleProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.contains(";"))
                    dialog.btnAccept.setDisable(true);
                else
                    dialog.btnAccept.setDisable(false);
            }
        });

        return dialog;
    }

    public static FXDialog newCustomDialog(String title, Severity severity) {
        final FXDialog dialog = new FXDialog(Type.CUSTOM, title, null);
        dialog.setKind(severity);
        return dialog;
    }

    private String      cbLabel;
    private Callable<?> cbAction;
    private Object      rtnObject;

    public void addAction(String prompt, Callable<?> action) {
        cbLabel = prompt;
        cbAction = action;
    }

    public TextField addTextField(String label) {
        final Label l = new Label(label);
        TextField tf = new TextField();
        tf.setUserData(l);
        pneCustom.add(l);
        pneCustom.add(tf, new CC().growX().wrap());
        if (inputField == null)
            inputField = tf;
        tf.visibleProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                l.setVisible(newValue);
            }
        });
        return tf;
    }

    public CheckBox addCheckBox(String label) {
        CheckBox cb = new CheckBox(label);
        pneCustom.add(cb, "wrap");
        return cb;
    }

    public <T> ComboBox<T> addComboBox(String label, ObservableList<T> items) {
        Label l = new Label(label);
        ComboBox<T> cb = new ComboBox<>(items);
        cb.setUserData(l);
        pneCustom.add(l);
        pneCustom.add(cb, new CC().growX().wrap());
        return cb;
    }

    public Boolean open(ButtonSet buttonSet) {
        setButtons(buttonSet, cbLabel);
//      ValidationUtils.addGlobalValidator(pneCustom, ValidationEvent.VALIDATION_INFO, (EventHandler<ValidationEvent>) ev -> {
//          btnAccept.setDisable(ValidationUtils.compare(ev, ValidationEvent.VALIDATION_INFO) > 0);
//      });
        return open();
    }

    public Object getResult() {
        return rtnObject;
    }

    /**
     * Static method responsible for the displaying of a confirmation dialog
     * box, providing a simple binary choice against some question.
     * 
     * @param caption
     *            : the text of the question to ask to the user
     * @param title
     *            : the title of the confirmation dialog
     * @param confirmType
     *            : available confirmation types are: DELETE_OPTION,
     *            YES_NO_OPTION, ACCEPT_DECLINE_OPTION, each one to set a
     *            different text for the binary choice buttons that will appear
     * @return
     */
    public static Boolean showConfirmDialog(String caption, String title, ButtonSet buttonSet) {
        return showConfirmDialog(caption, title, buttonSet, Severity.QUESTION);
    }

    public static Boolean showConfirmDialog(String caption, String title, ButtonSet buttonSet, Severity severity) {
        FXDialog dialog = new FXDialog(Type.CONFIRMATION, title, caption);

        dialog.setKind(severity);
        dialog.setButtons(buttonSet);

        return dialog.open();
    }

    /**
     * Static method responsible for the displaying of an input dialog box,
     * providing an input field to type some (short) text in.
     * 
     * @param caption
     *            : the text of the message to display
     * @param title
     *            : the title of the input dialog
     * @return some input text the user typed in
     */
    public static String showInputDialog(String caption, String title) {
        return showInputDialog(caption, title, ButtonSet.ACCEPT_DECLINE_OPTION, Severity.QUESTION);
    }

    public static String showInputDialog(String caption, String title, ButtonSet buttonSet) {
        return showInputDialog(caption, title, buttonSet, Severity.QUESTION);
    }

    public static String showInputDialog(String caption, String title, Severity severity) {
        return showInputDialog(caption, title, ButtonSet.ACCEPT_DECLINE_OPTION, severity);
    }

    public static String showInputDialog(String caption, String title, ButtonSet buttonSet, Severity severity) {
        FXDialog dialog = new FXDialog(Type.INPUT, title, caption);

        dialog.setKind(Severity.QUESTION);
        dialog.setButtons(ButtonSet.ACCEPT_DECLINE_OPTION);

        dialog.inputField.requestFocus();

        return (dialog.open() ? dialog.inputField.getText().trim() : null);
    }

    public static abstract class Callable<T> implements java.util.concurrent.Callable<T> {
        protected String    input;

        private T doit(String input) {
            this.input = input;
            try {
                T t = call();
                return t;
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage());
            }
        }
    }

    public static Object showExtendedInputDialog(String caption, String title, String prompt, Callable<?> action) {
        return showExtendedInputDialog(caption, title, prompt, action, ButtonSet.OK_CANCEL_OPTION, Severity.QUESTION);
    }

    public static Object showExtendedInputDialog(String caption, String title, String prompt, Callable<?> action, ButtonSet buttonSet) {
        return showExtendedInputDialog(caption, title, prompt, action, buttonSet, Severity.QUESTION);
    }

    public static Object showExtendedInputDialog(String caption, String title, String prompt, Callable<?> action, Severity severity) {
        return showExtendedInputDialog(caption, title, prompt, action, ButtonSet.OK_CANCEL_OPTION, severity);
    }

    public static Object showExtendedInputDialog(String caption, String title, String prompt, Callable<?> action, ButtonSet buttonSet, Severity severity) {
        FXDialog dialog = new FXDialog(Type.INPUT, title, caption);

        dialog.setKind(severity);
        dialog.setButtons(buttonSet, prompt);

        if (!dialog.open())
            return null;

        String value = dialog.inputField.getText().trim();
        if (dialog.ckbAction.isSelected()) {
            Object o = action.doit(value);
            if (o != null)
                return o;
        }
        return value;
    }

    protected Object userObject;
    public void setData(Object obj) {
        userObject = obj;
    }
    public Object getData() {
        return userObject;
    }
    public static void setVisible(Node node, boolean b) {
        node.setVisible(b);
        Object o = node.getUserData();
        if (o instanceof Node) {
            ((Node) o).setVisible(b);
        }
    }
    // load a custom css File
    public void loadCSS(File f) {
        if (f.exists()) {
            try {
                root.getStylesheets().add(f.toURI().toURL().toExternalForm());
            } catch (MalformedURLException e) {
            }
        }
    }
}