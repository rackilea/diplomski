import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.testgson.beans.Example;

public class Main {
    private static Gson gson;

    static {
        gson = new GsonBuilder().create();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
         String j = "{\"Status\":\"true\",\"Result\":{\"rows\":{\"row\":{\"status\":true,\"subareas\":[{\"nome\":\"Associacao Utente\",\"id\":9,\"grafs\":{\"rows\":[{\"id\":6,\"nome\":\"AssociacaoUtente\",\"tipo\":\"PIE\",\"serv\":\"MV_AS_UTENTE_POR_NEGOCIO\",\"periodo\":\"ANO\"}]}},{\"nome\":\"Chaves\",\"id\":60,\"grafs\":{\"rows\":[{\"id\":35,\"nome\":\"ChavesCriadosporano\",\"tipo\":\"LINHA\",\"serv\":\"MV_ASSOC_TOTAL_CHAVES\",\"periodo\":\"ANO\"},{\"id\":592,\"nome\":\"ChavesAssociadoAoUserPortal\",\"tipo\":\"BAR\",\"serv\":\"MV_ASSOC_USER_CHAVES\",\"periodo\":\"TODOS\"},{\"id\":593,\"nome\":\"ChavesAssociadoAoNegocios\",\"tipo\":\"BAR\",\"serv\":\"MV_ASSOC_CHAVES\",\"periodo\":\"TODOS\"}]}}]}}}}";
         Example r = gson.fromJson(j, Example.class);
         System.out.println(r);
    }
}