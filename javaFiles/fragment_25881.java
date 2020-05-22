import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;

public class UserAccountPersistence {

    private ObservableList<User> users = FXCollections.observableArrayList();

    public UserAccountPersistence() throws JAXBException, IOException {
        File dbFile = getDatabaseFilePath();
        if (dbFile == null) {
            setDatabaseFilePath(new File(System.getProperty("user.home") + "/" + "user-account.xml"));
            dbFile = getDatabaseFilePath();
        }

        if (!dbFile.exists()) {
            createTestData();
            saveData(dbFile);
        } else {
            loadData(dbFile);
        }

        System.out.println("Persisted Data: ");
        System.out.println(
                Files.lines(dbFile.toPath())
                        .collect(Collectors.joining("\n"))
        );
        System.out.println("Database File: " + dbFile);
    }

    private void createTestData() {
        users.add(new User("Hans", "Muster"));
        users.add(new User("Ruth", "Mueller"));
        users.add(new User("Heinz", "Kurz"));

        users.get(0).accounts().addAll(
                new Account(10),
                new Account(20)
        );

        users.get(2).accounts().addAll(
                new Account(15)
        );
    }

    public File getDatabaseFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(UserAccountPersistence.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    public void setDatabaseFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(UserAccountPersistence.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());
        } else {
            prefs.remove("filePath");
        }
    }

    public void loadData(File file) throws JAXBException {
        JAXBContext context = JAXBContext
                .newInstance(UserListWrapper.class);
        Unmarshaller um = context.createUnmarshaller();

        UserListWrapper wrapper = (UserListWrapper) um.unmarshal(file);

        users.clear();
        users.addAll(wrapper.getPersons());

        setDatabaseFilePath(file);
    }

    public void saveData(File file) throws JAXBException {
        JAXBContext context = JAXBContext
                .newInstance(UserListWrapper.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        UserListWrapper wrapper = new UserListWrapper();
        wrapper.setPersons(users);

        m.marshal(wrapper, file);

        setDatabaseFilePath(file);
    }

    public static void main(String[] args) throws JAXBException, IOException {
        UserAccountPersistence userAccountPersistence = new UserAccountPersistence();
    }
}