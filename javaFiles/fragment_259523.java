@GET
@Path("/dd/{sp}/{rpt}/{ter}/{month}/{day}/{year}/{grant}/{refresh}")
@Produces(MediaType.APPLICATION_JSON)
public List<ReportPeriodBean> getApprovals(@PathParam("sp") String sp,
        @PathParam("rpt") String rpt, 
        @PathParam("ter") String ter,
        @PathParam("month") int month,
        @PathParam("day") int day,
        @PathParam("year") int year,
        @PathParam("grant") String grant, 
        @PathParam("refresh") boolean refresh) {

    LocalDate date = LocalDate.of(year, month, day);
    // Now use the date however you like

}