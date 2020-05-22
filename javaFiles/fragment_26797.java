import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.api.server.spi.ServiceException;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.ForbiddenException;
import com.google.api.server.spi.response.InternalServerErrorException;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.users.User;

@Api(
    name = "myendpoint",
    version = "v1",
    clientIds = {"ddddd.apps.googleusercontent.com"},
    audiences = {"xxxx"}
)
public class CloudSqlEndpoint {

    private static final Logger log = Logger.getLogger(CloudSqlEndpoint.class.getName());

    private static final String INSERT_ORDER_SQL = "INSERT INTO order (amount, user, status, address) VALUES( ? , ? , ? , ? )"; 

/**
 * Insert a row into cloud sql
 * @param order
 * @param user
 * @return
 */
@ApiMethod(name = "order.add")
public Order addOrder(Order order, User user) throws OAuthRequestException, 
    IOException, ServiceException {

    this.validateUser(user);

    log.info("adding order to cloud sql: " + order);

    try {
         String url = null;
         if (SystemProperty.environment.value() ==
              SystemProperty.Environment.Value.Production) {
            // Load the class that provides the new "jdbc:google:mysql://" prefix.
            Class.forName("com.mysql.jdbc.GoogleDriver");
            url = "jdbc:google:mysql://your-project-id:your-instance-name/guestbook?user=root";
        } else {
            // Local MySQL instance to use during development.
            Class.forName("com.mysql.jdbc.Driver");
            url = "jdbc:mysql://127.0.0.1:3306/guestbook?user=root";

            // Alternatively, connect to a Google Cloud SQL instance using:
            // jdbc:mysql://ip-address-of-google-cloud-sql-instance:3306/guestbook?user=root
        }
        try(Connection conn = DriverManager.getConnection(url)) {

            PreparedStatement stmt = conn.prepareStatement(INSERT_ORDER_SQL);
            stmt.setString(1, order.getAmount());
            stmt.setString(2, order.getUser());
            stmt.setString(3, "Open");
            stmt.setString(4, order.getAddress());

            stmt.executeUpdate();

        }

    } catch(Exception e) {

        log.log(Level.SEVERE, "Failed to create order", e);
        throw new InternalServerErrorException(e);
    }

    return order;
}

/**
 * Validate the current user 
 * @param user
 */
private void validateUser(User user) throws OAuthRequestException, ServiceException {

    // validate the users domain
    if (user == null) {
        throw new OAuthRequestException("Invalid user.");

    } else {
        String email = user.getEmail().toLowerCase();

        // any other validation
    }

}

}