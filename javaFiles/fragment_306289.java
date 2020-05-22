@Test
public void borrowingRestrictedWhenCardSwipedHasExceededFineLimit() throws Exception {
    when(memberDAO.getMemberByID(42)).thenReturn(member);
    when(member.hasReachedFineLimit()).thenReturn(true);

    ctl.initialise();
    ctl.cardSwiped(42);

    String errorMessage = "Member %d cannot borrow at this time.";
    errorMessage = String.format(errorMessage, 42);

    verify(ui).displayErrorMessage(errorMessage);
}