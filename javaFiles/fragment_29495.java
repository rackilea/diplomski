$(document).ready(function() {
   PF('pickListVar').jq.on('click','.ui-picklist-target li',function(){
       updateCommand();//remoteCommand to update
       //and you can get the item value and lable
       $(this).attr('data-item-value');
       $(this).attr('data-item-lable');
   });
});