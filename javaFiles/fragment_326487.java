@Test
public void shouldReturnCandidateById() throws Exception {
    //ARRANGE
    Candidate candidate = getATestCandidate();
    when(candidateService.findById(candidate.getId())).thenReturn(candidate);
    RequestBuilder requestBuilder = get(
           "/candidates/" + candidate.getId()).accept(
            MediaType.APPLICATION_JSON);

    //ACT 
    MvcResult result = mockMvc.perform(requestBuilder).
    //ASSERT
                           .andExpect(status().is(200))
                           .andExpect(jsonPath("$.id", is(candidate.getId())))
                           ...
                           //here you are checking whether your controller returns the
                           //correct JSON body representation of your Candidate resource 
                           //so I would do jsonPath checks for all the candidate fields
                           //which should be part of the response

}