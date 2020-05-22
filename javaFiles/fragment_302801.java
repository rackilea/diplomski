import java.util.ArrayList;

public class Store {
int appNumber;// = appNumberField.getText();
String name;// = nameField.getText();
int date;// = dateField.getText();
boolean fileLoc;// = fileLocField.getText();
String country;// = countryRefField.getText();

public Store(int appNumbe, String nam, int dat, boolean fileLo,
        String countr) {
    appNumber = appNumbe;
    name = nam;
    date = dat;
    fileLoc = fileLo;
    country = countr;
}

public static void main(String[] args) {

    ArrayList<Store> app = new ArrayList<Store>();
    app.add(new Store(22, "Name", 2, false, "India"));

}
}