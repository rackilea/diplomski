function addOne(thenRunThisFunction) {
  waitAMinuteAsync(function waitedAMinute() {
    thenRunThisFunction()
  })
}
addOne(function thisGetsRunAfterAddOneFinishes(){})