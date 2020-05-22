$(function(){
   $('#formId').on('submit', function(event){
       event.preventDefault();// stop browser submitting from
       var data = $(this).serialize();
       $.post('/updatePing', data , function(response){
             $("#resultsBlock").html(response);
       }).fail(function(){
             alert('Something went wrong')
       });
   });
});