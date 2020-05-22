import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

 ...

 @Test
 public void changePasswordWorks() throws Exception {
     // Send password change request
     PasswordChangeRepresentation passwordChange = new PasswordChangeRepresentation(DefaultUsers.Admin.getPassword(), "12345678");
     mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/password/change")

             // ADD this line
             .with(user("admin").roles("USER","ADMIN"))

             .content(new ObjectMapper().writeValueAsString(passwordChange))
             .contentType(MediaType.APPLICATION_JSON)
             .accept(MediaType.APPLICATION_JSON))
             .andExpect(status().isOk());

     // Check that the password has been changed
     User user = this.userRepository.findByUsername(DefaultUsers.Admin.getEmail());
     Assert.assertEquals(user.getPassword(), "12345678");
}