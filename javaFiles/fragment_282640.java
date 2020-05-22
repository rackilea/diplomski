@Test
public void shouldUpdateRoleToAdmin() {
    // When
    userService.updateRoleToAdmin(anyLong());

    // Then
    verify(userRepo, times(1)).updateRoleToAdmin(anyLong()); 
}