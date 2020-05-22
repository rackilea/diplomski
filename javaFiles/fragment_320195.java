function setupEventBus() {
  var eb = new EventBus(window.location.protocol + "//" + window.location.host + "/eventbus");
  eb.onclose = function (e) {
    // Cleanup reply handlers
    var replyHandlers = eb.replyHandlers;
    for (var address in replyHandlers) {
      if (replyHandlers.hasOwnProperty(address)) {
        replyHandlers[address]({
          failureCode: -1,
          failureType: "DISCONNECT",
          message: "EventBus closed"
        });
      }
    }
    // Setup the EventBus object again (after some time)
    setTimeout(setupEventBus, 1000);
  };
  eb.onopen = function () {
    // Register your handlers here
  };
}