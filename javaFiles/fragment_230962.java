$(function(){
          $('.selectOption').change(function(){
            var selected = $(this).find(':selected').text();
            //alert(selected);
            $(".desc").hide();
             $('#' + selected).show();
          }).change()
});