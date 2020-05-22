YAHOO.util.Event.onDOMReady(function(){
  function killIt(e){
    YAHOO.util.Event.stopEvent(e);
  }

  var anchors = document.getElementsByTagName('a');
  for(var i = 0; i < anchors.length; i++){
     YAHOO.util.Event.addListener(anchors[i], 'click', function(e){
       var el = YAHOO.util.Event.getTarget(e);
       YAHOO.util.Event.removeListener(el, 'click'); // kill existing handle
       YAHOO.util.Event.addListener(el, 'click', killIt); // kill any future clicks
     });
   }
});