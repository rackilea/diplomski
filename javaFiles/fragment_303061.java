$(document).ready(function() {
     var count=0;
     function change(){
        $('.change').text(count++);
        setTimeout(change,1000);
    }

   change();

});