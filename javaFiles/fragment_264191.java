public boolean untilAngular2HasFinishedProcessing()
  {
    until(() ->
      {
        log.info("Waiting on angular 2+ to finish processing");
        final boolean isReady = (Boolean.valueOf(((JavascriptExecutor) driver)
          .executeScript(
            "try{" +
          "return (window.getAllAngularTestabilities()[0]._ngZone.hasPendingMicrotasks == " +
          "false && " +
          "window.getAllAngularTestabilities()[0]._ngZone.hasPendingMacrotasks == false && " +
          "window.getAllAngularTestabilities()[0]._ngZone._nesting == 0 &&" +

          "window.getAllAngularTestabilities()[0]._ngZone.isStable == true)" +
          "}" +
          "catch(err) {" +
          "if (err.message == ('window.getAllAngularTestabilities is not a function'))" +
          "{" +
          "return true" +
          "}" +
          "}")
          .toString()));
        log.info("Is Angular 2+ ready? " + isReady);
        return isReady;
      }
    );
    return true;
  }