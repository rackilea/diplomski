window._junit_testid_ = '*none*';
window._junit_async_calls_ = {};
function _setJunitTestid_(testId) {
  window._junit_testid_ = testId;
}
function _setTimeout_(cont, timeout) {
  var callId = Math.random().toString(36).substr(2);
  var testId = window._junit_testid_;
  window._junit_async_calls_[testId] |= {};
  window._junit_async_calls_[testId][callId] = 1;
  window.setTimeout(function(){
    cont();
    delete(window._junit_async_calls_[testId][callId]);
  }, timeout);
}
function _isTestDone_(testId) {
  if (window._junit_async_calls_[testId]) {
    var thing = window._junit_async_calls_[testId];
    for (var prop in thing) {
      if (thing.hasOwnProperty(prop)) return false;
    }
    delete(window._junit_async_calls_[testId]);
  }
  return true;
}