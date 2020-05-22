public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {

            StringBuilder sb = new StringBuilder();
            BufferedReader br = req.getReader();
            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }

            String json = sb.toString();


            JsonReader jsonReader = Json.createReader(new StringReader(json));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();

            // an object with three fields.
            User u = new User(jsonObject.getString("email"), "10010099", jsonObject.getString("pass"));

            // construct json answer.
            // based on https://www.youtube.com/watch?v=BPMVC999HTs
            JsonObject root;
            JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
            JsonObjectBuilder userBuilder = Json.createObjectBuilder();
            userBuilder.add("name", u.getName()).add("email", u.getEmail()).add("sid", u.getSId());

            root = rootBuilder.add("login", userBuilder).build();
            // write response to out
            out.println(root);
            out.flush();
            out.close();
        }
    }
}