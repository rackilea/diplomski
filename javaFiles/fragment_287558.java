@Path("/donnees")
public class Resource
{
//    Connection con=null;


    @Path("/agendas")
    @GET
    @Produces("application/xml")
    public ArrayList<Activite> getActivite()
    {
        ArrayList<Activite> activitelist = new ArrayList<Activite>();
        try
        {
            System.out.println("entrée");
            activitelist = new AccessAgenda().getActivites();

        } catch (Exception e)
        {
            System.out.println("erreur");
            e.printStackTrace();
        }
        return activitelist;
    }