$(function (){
    if($('#a_principal').val()== "true"){           
         $("input:checkbox").prop('checked',true);
    }else{
        $("input:checkbox").prop('checked', false);
    }
});