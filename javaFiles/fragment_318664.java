import java.io.IOException;
import java.util.List;

import com.google.api.services.admin.directory.Directory;
import com.google.api.services.admin.directory.model.User;
import com.google.api.services.admin.directory.model.Users;

    public static List<User> listUser(Directory directory) throws IOException {
        Users users = directory.users().list().setCustomer("my_customer").execute();
        return users.getUsers();
    }