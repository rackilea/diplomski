import java.sql.SQLException;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.db.DBConnection;
import com.hp.hpl.jena.rdf.model.ModelMaker;
import com.hp.hpl.jena.rdf.model.ModelFactory;

public class TestJena {

    public static void main(String[] args) throws java.lang.ClassNotFoundException, java.sql.SQLException {
        Class.forName("com.mysql.jdbc.Driver");            

        //The database backend initialization.
        DBConnection connection = new DBConnection(MY_DB, USER, PASS, "mysql");
        ModelMaker dbMaker = ModelFactory.createModelRDBMaker(connection);

        //A file manager to get the triples from the DBPedia revolvable URI. 
        FileManager fManager = FileManager.get();
        fManager.addLocatorURL();
        Model linkedDataModel =
              fManager.loadModel("http://dbpedia.org/data/Frederick_of_Sweden.rdf");


        //Now we copy the in-memory model into our DB backend. 
        //When the model is created you can give it the name that you like.
        Model dbModel = 
              dbMaker.createModel("http://dbpedia.org/resource/Frederick_of_Sweden");

        dbModel.add(linkedDataModel);

        StmtIterator iter = dbModel.listStatements();
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();
            System.out.println(stmt);
        }


        linkedDataModel.close();
        dbModel.close();
        connection.close();
}