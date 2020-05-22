function deselectChecks(selected){
     for each (var checkId in checkIds) {
          if (checkId != selected){
              document.getElementById(checkId).checked = false;
          }
     }
}