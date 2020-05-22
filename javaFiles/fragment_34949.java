function del_form(){

var s_id=document.Delete.s_id;

if(s_id.value == "")

{

 //window.alert("Please enter the ID!");

    alert("Please enter the ID!");

    return false;

   }

 return true;

}