@Test
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public void testHistoryLogging() {
    Candidate cand = new Candidate();
    cand.setEmail("123@gmail.com");
    cand.setFirstName("12");
    cand.setLastName("3");

    cand = candidateRepository.save(cand);

    cand.setLastName("34");
    candidateRepository.save(cand);

    assertEquals(entityAuditEventRepository.findAll().size(), 1);

}