import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataProvider {
public static HashMap<String, List<String>> getInfo;

    public DataProvider() { 

        HashMap<String, List<String>> MoviesDetails = new HashMap<String, List<String>>();

        List<String> Action_Movies = new ArrayList<String>();
        Action_Movies.add("");
        List<String> Romantic_Movies = new ArrayList<String>();

        Romantic_Movies.add("");
        List<String> Horror_Movies = new ArrayList<String>();
        Horror_Movies.add("");
        List<String> Comedy_Movies = new ArrayList<String>();
        Comedy_Movies.add("");

    }

}