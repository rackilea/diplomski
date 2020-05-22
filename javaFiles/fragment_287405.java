$(function() {
  
  // if agent is of Chrome
  var isChrome = /chrom(e|ium)/.test(navigator.userAgent.toLowerCase());
  
  if (isChrome) {
    $("table td>:input").wrap($("<div>", {"class": "input-container"}));
  }
});