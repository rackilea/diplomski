$(document).ready(function() {
     var folders = getConfigLinkedFolders();

     if(folders && folders.length > 0) {
          $('#par2').addClass('hide');
     } else {
          $('#par1').addClass('hide');
     }
});

function getConfigLinkedFolders {
    return arrayList; /*["defssfsf","hrhrhhr"] */
}