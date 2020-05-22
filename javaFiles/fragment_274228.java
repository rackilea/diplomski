import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import java.util.Arrays;
import java.util.List;


public class adding {

    static Driver driver;

    public static void main(String args[]) {
        driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j","neo4j"));
        Session session = driver.session();

        List<String> userList = Arrays.asList("bob","tom","bob");
        userList.forEach(user->{
            StatementResult result = session.run( "MATCH (a:Person {username: '"+user+"'}) RETURN a");
            //Check if the node exists and create only if node doesn't exists
            if(!result.hasNext()){
                session.run("CREATE (n:Person {username: '"+user+"'})");
            }
        });
    }
}