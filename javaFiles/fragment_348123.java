$(document).ready(function(){

$("tr.rows").click(function() {
    var rowid=this.id; 

var tierOneIndex = $('#tierOneIndex_'+rowid).val();
var tierTwoIndex = $('#tierTwoIndex_'+rowid).val();                         
var budgetItemIndex = $('#budgetItemIndex_'+rowid).val(); 

    console.log("tierOneIndex:"+tierOneIndex);
    console.log("tierTwoIndex:"+tierTwoIndex);
    console.log("budgetItemIndex:"+budgetItemIndex);
});

    });