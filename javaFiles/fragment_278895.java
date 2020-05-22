@Test
   public void updateTest() throws ClassNotFoundException, SQLException {
MilestoneDAOImpl ms = new MilestoneDAOImpl();
Milestone milestone = new Milestone("test","test");
assertNotNull("milestone updated", ms.update(milestone));  
Milestone milestone1=ms.select(milestone.getId());

assertEquals(milestone1.getName(),milestone.getName());
assertEquals(milestone1.getdescrition(),milestone.getDescription());
        }