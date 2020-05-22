import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import net.minidev.json.JSONArray;
import com.jayway.jsonpath.Predicate;
import static com.jayway.jsonpath.JsonPath.parse;

public class JaywayJSON {
    public static void main(String[] args) throws IOException {
        String json = readFile("C:\\test_stackoverflow\\jayway.json",
                Charset.defaultCharset());

        /*
         * //Solution 1
         * 
         * Filter responseFilter =
         * Filter.filter(Criteria.where("errorMsg").is("INACTIVE"));
         * 
         * Map<String, Object> inactiveFailedCompany =
         * parse(json).read("$.payload[1].['Failed company(ies)'][1]",
         * responseFilter);
         * 
         * System.out.println("Company Object > " +
         * inactiveFailedCompany.toString()); //output: Output > {id=COM002FILE,
         * index=NA, errorMsg=[["INACTIVE"],["INVALID_LOCATION","INACTIVE"]]}
         * 
         * System.out.println("Company ID > " +
         * inactiveFailedCompany.get("id")); //output: COM002FILE
         */

        // solution 2
        Predicate inactiveCompaniesPredicate = new Predicate() {
            @Override
            public boolean apply(PredicateContext ctx) {
                if (ctx.item(Map.class).containsKey("errorMsg")
                        && ((JSONArray) ((JSONArray) ctx.item(Map.class).get(
                                "errorMsg")).get(0)).get(0).equals("INACTIVE")) {
                    return true;
                } else {
                    return false;
                }
            }
        };

        List<Map<String, Object>> failedCompanies = parse(json).read(
                "$.payload[1].['Failed company(ies)'][?]", List.class,
                inactiveCompaniesPredicate);

        for (Map<String, Object> object : failedCompanies) {
            System.out.println(object.get("id"));
        }
    }

    public static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}