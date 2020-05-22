import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;

public class SignRequestServlet extends HttpServlet{

    public void doGet(HttpServletRequet request, HttpServletResponse response) throws ServletException, IOException{

        long unixTime = System.currentTimeMillis() / 1000L;
        String unsignedData = "&quot;api_key&quot;:&quot;874837483274837&quot;,&quot;timestamp&quot;:&quot;" + unixTime + "&quot;";
        String unsignedDataForSHA = "timestamp="+unixTime;
        String apiSecret = "-----place your api secret here-----";
        String unsignedDataSecret = unsignedDataForSHA + apiSecret;
        String signedData = unsignedData + ",&quot;signature&quot;:&quot;" + DigestUtils.shaHex(unsignedDataSecret.getBytes()) + "&quot";

        JSONObject jsonObject = new JSONObject("{" + signedData.replaceAll("&quot;", "\"") + "}");

        request.setAttribute("signedData", jsonObject.toString());
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequet request, HttpServletResponse response) throws ServletException, IOException{

        doGet(request, response);
    }
}