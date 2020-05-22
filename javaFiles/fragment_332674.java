@Path("/loadtable")
@GET
@Produces(MediaType.APPLICATION_JSON)
public List<Pricing> loadTable(@QueryParam("tablename") String tablename) throws Exception {
    List<Pricing> pricing = new ArrayList<Pricing>();
    try {
        query = c.prepareStatement("select * from " + tablename);
        ResultSet ets_rs = query.executeQuery();

        while (ets_rs.next()) {
            pricing.add(new Pricing(ets_rs.getString(1), ets_rs.getString(2),  ets_rs.getString(3), ets_rs.getString(4), ets_rs.getString(5), ets_rs.getString(6)));
        }
        query.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (c != null) {
            c.close();
        }
    }
    return pricing;
}