public class Payload extends HttpServlet {

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    StringBuilder builder = new StringBuilder();
    String aux = "";

    while ((aux = req.getReader().readLine()) != null) {
        builder.append(aux);
    }

    String text = builder.toString();
    try {
        JSONObject json = new JSONObject(text);
        String teams_url = json.getJSONObject("repository").getString("teams_url");
        System.out.println("Teams URL:: "+teams_url);
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }}