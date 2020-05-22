function Validate() {
var x=document.forms["sform"]["prod"];
for(var i=0;i<x.length;i++){
    if(x[i].type=='checkbox'&&x[i].checked==true) {
        return true;
    }
}
alert("Please select the products available and click save");
return false;