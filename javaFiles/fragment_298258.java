@Test
public void aTestMethod(<any number of mock parameters>)
{
   // Record phase: expectations on mocks are recorded; empty if nothing to record.

   // Replay phase: invocations on mocks are "replayed"; code under test is exercised.

   // Verify phase: expectations on mocks are verified; empty if nothing to verify.
}