#set ($allLegs = $ConfirmationObject.getAllLegs())
    #set ($columns = $allLegs.keySet())
    #set ($maxCols = 3)
    #set ($groups = ($columns.size() + $maxCols - 1)/$maxCols)
    #set ($lastGroup = $groups - 1)

    #foreach ($group in [0..$lastGroup])
    #if($group >0 )
    <br>
    <br>
    #end
    <table style="font-family:Arial;font-size:xx-small;color:black" width="100%" border="0" cellspacing="0" cellpadding="0">
     #set ($allLegs = $ConfirmationObject.getAllLegs())
     #set ($i = (($group*$maxCols)+1))
     #set ($groupLegs = $ConfirmationObject.getGrouplLegSet($group, $maxCols))

     <tr>
      <td valign="top" width="30%"> </td>
       #foreach($legSzie in $groupLegs.keySet())
        <td valign="top" width="30%" align="left"><b>Leg $i</b></td>
         #set ($i=$i+1)
       #end
      <td></td>
      <td valign="top" width="10%" align="right">&nbsp;</td>
     </tr>

     <td colspan="1">
      <table style="font-family:Arial;font-size:xx-small;color:black" width="100%" border="0" cellspacing="0" cellpadding="0">
       #set ($map = $ConfirmationObject.getLegMap(1))
       #foreach($key in $map.keySet())
        <tr>
         <td valign="top" width="60%">$key </td>
        </tr>
       #end
      </table>
     </td>

     #foreach($legString in $groupLegs.keySet())
     <td colspan="1">
      <table style="font-family:Arial;font-size:xx-small;color:black" width="100%" border="0" cellspacing="0" cellpadding="0">
       #set ($legMap = $allLegs.get($legString))
       #foreach($legKey in $legMap.keySet())
        <tr>
         <td >$legMap.get($legKey)</td>
        </tr>
       #end
      </table>
     </td>
   #end
  </table>
 #end