<input type="checkbox" idm="stuff" name="status" value="1">
<input type="checkbox" idm="stuff" name="status" value="2">
<input type="checkbox" idm="stuff" name="status" value="3">  

<script>
 $(document).ready(function(e) {
$('input[name=status]').change(function(){
    if( $(this).prop('checked') ) {checkboxstatus = '1';}
                             else {checkboxstatus = '0';}
        var idm = $(this).attr('idm'); 
        $.ajax({
           type: "POST",
           url: "checkboxtestbackend.php",
           data: {"checkboxstatus": checkboxstatus, "idm":idm },
           success: function(response){
              console.log(response);  
             }
        })        
        .fail(function(jqXHR, textStatus, errorThrown){alert(jqXHR+"--"+textStatus+"--"+errorThrown);});
});//end change
});//end ready 
</script>