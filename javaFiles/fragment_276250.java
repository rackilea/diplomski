@Test
public void flow_ends_on_cancel_from_start_state() {
    startFlow(context);
    context.setEventId("cancel");
    resumeFlow(context);
    assertFlowExecutionEnded();
    assertFlowExecutionOutcomeEquals("endStateId");
}