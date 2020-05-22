import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;

public class ViewMyAccount implements Initializable {

    public Label errorPassword;
    public Label errorMobile;
    public Label errorEmail;
    public Label errorLastName;
    public Label errorFirstName;
    public TextField notes;
    public TextField address;
    public PasswordField confirmPassword;
    public PasswordField password;
    public TextField occupation;
    public TextField mobile;
    public TextField email;
    public TextField lastName;
    public TextField firstName;
    public Button updateButton;
    public Button backButton;
    //I don't have this code...

    //Connectivity connection = new Connectivity();
    //Connection connec = connection.getConnection();
    //registerValidation validate = new registerValidation();
    //SceneSwitcher sceneSwitcher = new SceneSwitcher();


    public String mail = "mangalika@gmail.com"; //I want the logged in mail to assign this 

    public String setAndReturnMail(String userEnteredValue) {
        this.mail = userEnteredValue;
        return this.mail;
    }

    public void initialize(URL url, ResourceBundle rb) {

            //fill info in fields
            PreparedStatement pstmtGetInfo = null;
            ResultSet rslt = null;
            String sqlGetInfo = "SELECT * FROM users WHERE email=?";
            System.out.println(mail);

            /*
            try {
                pstmtGetInfo = connec.prepareStatement(sqlGetInfo);
                pstmtGetInfo.setString(1,mail);
                rslt = pstmtGetInfo.executeQuery();

                if(rslt.next()){
                    StringBuffer stringBuffer1 = new StringBuffer();
                    stringBuffer1.append(rslt.getString("firstName"));
                    firstName.setText(stringBuffer1.toString());

                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(rslt.getString("lastName"));
                    lastName.setText(stringBuffer2.toString());

                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(rslt.getString("email"));
                    email.setText(stringBuffer3.toString());

                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(rslt.getString("mobile"));
                    mobile.setText(stringBuffer4.toString());

                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(rslt.getString("occupation"));
                    occupation.setText(stringBuffer5.toString());

                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append(rslt.getString("address"));
                    address.setText(stringBuffer6.toString());

                    StringBuffer stringBuffer7 = new StringBuffer();
                    stringBuffer7.append(rslt.getString("password"));
                    password.setText(stringBuffer7.toString());
                    confirmPassword.setText(stringBuffer7.toString());

                    StringBuffer stringBuffer8 = new StringBuffer();
                    stringBuffer8.append(rslt.getString("notes"));
                    notes.setText(stringBuffer8.toString());
                }else{
                    System.out.println("no rows for this mail ID");
                }

            } catch (SQLException e) {
                System.err.println(e);

            }
            */

        }


        public void updateButtonClicked(ActionEvent actionEvent) throws SQLException{

           /* boolean isFirstNameEmpty = validate.emptyError(firstName,errorFirstName,"First name is required!");
            boolean isFirstNameNum = validate.isNotNum(firstName,errorFirstName,"First name can't be numbers!");
            boolean isLastNameEmpty = validate.emptyError(lastName,errorLastName,"Last name is required!");
            boolean isLastNameNum = validate.isNotNum(lastName,errorLastName,"Last name can't be numbers!");
            boolean isEmailEmpty = validate.emptyError(email,errorEmail,"Email address is required!");
            boolean isPasswordEmpty = validate.emptyError(password,errorPassword,"Password is required!");
            boolean isemailValid = validate.isValidEmailAddress(email);
            boolean isPasswordValid = validate.isValidPassword(password,confirmPassword,errorPassword);
            boolean isPasswordMatched = validate.isPasswordMatch(password,confirmPassword);
            boolean isUserNameExist = validate.checkUsernameExists(email.getText(),connec,errorEmail);

            if(isFirstNameEmpty && isFirstNameNum && isLastNameEmpty && isLastNameNum && isEmailEmpty && isPasswordEmpty && isPasswordValid && isemailValid && isPasswordMatched && isUserNameExist){
                PreparedStatement pstmt = null;
                String sql = "UPDATE users\n" +
                        "SET firstName = ?, lastName= ?, email= ?, mobile= ?, occupation= ?, address= ?, password= ?, notes= ?\n" +
                        "WHERE email = ?;";

                try {
                    pstmt = connec.prepareStatement(sql);
                    pstmt.setString(1,firstName.getText());
                    pstmt.setString(2,lastName.getText());
                    pstmt.setString(3,email.getText());
                    pstmt.setString(4,mobile.getText());
                    pstmt.setString(5,occupation.getText());
                    pstmt.setString(6,address.getText());
                    pstmt.setString(7,password.getText());
                    pstmt.setString(8,notes.getText());
                    pstmt.setString(9,mail);

                    int i = pstmt.executeUpdate();
                    System.out.println("customer info UPDATE status = " + i);

                    if(i == 1){
                        AlertBox.displayAlertBox("Congratulations!","You have successfully registered to JFS");
                        sceneSwitcher.switchScene(updateButton,"sample.fxml","JFS");
                    }else{
                        AlertBox.displayAlertBox("Error","Database couldn't be updated");
                    }



                } catch (SQLException e) {
                    System.err.println(e);
                }finally {
                    pstmt.close();
                }

                AlertBox.displayAlertBox("Congratulations!","You have successfully updated your account");
                sceneSwitcher.switchScene(updateButton,"sample.fxml","JFS");

            }else{
                System.out.println("Validation failed");
            }

             */
        }

        public void backButtonClicked(ActionEvent actionEvent) {
           // sceneSwitcher.switchScene(backButton,"customerView.fxml","Welcome to JFS ");
        }

}