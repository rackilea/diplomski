getPlayerNames = function(){
  var selected = document.querySelectorAll("#selected-players > tr > td");
  var playernames = [];
  for(var i=0; i<selected.length; ++i){
     var id = selected[i].getAttribute('id');
     if (id.indexOf('Player')>-1) {
         playernames.push(selected[i].textContent);
     }

  }
  return playernames;    
}