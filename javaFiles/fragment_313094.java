@Test
public void shouldEditDescriptionOfTheUser() throws UserNotFoundException{
   databuilderService.createAll(); //I would create just a single user instead
   User user = userService.findByEmail("abc@gmail.com");

   String newDesciption = "It's a description about the user";
   Assert.notEquals("precondition", newDesciption , user.getAboutMe);      

   xxx.editDescription(user, newDesciption); 

   Assert.assertEquals(newDesciption, user.getAboutMe());
}