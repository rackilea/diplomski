@Test
   public void createTest() throws ClassNotFoundException, SQLException {
   try{
   MilestoneDAOImpl ms = new MilestoneDAOImpl();
Milestone milestone = new Milestone("test","test");
assertNotNull("milestone updated", ms.update(milestone));   
}catch (ClassNotFoundException e1)
{
// do some assertions based on scenarios like some relevent jars are missed in classpath
}
catch (SQLException e2)
{
// do some assertions like wrong connection URL etc.
}
}