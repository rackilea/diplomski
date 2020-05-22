@Test
public void shouldReturnNotFoundWhenGetCandidateByNonExistingId() {
    //the Arrange part in your test 
    doThrow(new ResourceNotFoundException(candidate.getId())).when(candidateService).deleteById(anyInt());

    //call mockMvc 

    //assert not found using the MockMvcResultMatchers
}