$(function() {
   $('.save').on("click",function(e) { // passing event
     e.preventDefault(); // jQuery will normalise it for all modern browsers
     // post the href of the link to the server and return the result in a 
     // container with ID result
     $.post($(this).attr("href"), function(data) { // or $.get if you want
       $('#result').html(data);
     });
  });