@Test
public void verifyAuditing(@Cascading final Logger logging)
{
    // Call code under test which will create auditing records.

    new Verifications() {{ logging.info("expected audit info"); }};
}