@Test
 public void getUserById() {
   User user = new User("name", "1234");
   when(userRepository.findbyId("1234")).thenReturn(Optional.ofNullable(user));
    // first method call
   User user1 = userService.findbyId("1234");
   assertThat(user.getName()).isEqualTo(user1.getName());
   assertThat(user.getId).isEqualTo(user1.getId());
 }
 //ensure this test case is executed after getUserById. I used 
 //@FixMethodOrder(MethodSorters.NAME_ASCENDING)
 @Test
 public void getUserById_cache() {
   User user1 = userService.findbyId("1234");
   Mockito.verify(userRepository, never()).findbyId("1234")
   assertThat(user.getName()).isEqualTo(user1.getName());
   assertThat(user.getId).isEqualTo(user1.getId());
 }