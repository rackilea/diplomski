@WebServlet("/dial/participant")
public class AddParticipantToConference extends HttpServlet {

    public static final String MODERATOR = System.getenv("MY_PHONE_NUMBER");
    public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
    public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

    @Override
    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
            throws IOException {    
        String selectedOption = servletRequest.getParameter("Digits");

        VoiceResponse twiml;

        if(selectedOption != null){
            Call call = Call.creator(new PhoneNumber("+" + selectedOption), new PhoneNumber(MODERATOR),
        new URI("https://example.com/conference")).create();
        }

        twiml = new VoiceResponse.Builder().redirect("/conference").build();

        servletResponse.setContentType("text/xml");

        try {
            servletResponse.getWriter().print(twiml.toXml());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}