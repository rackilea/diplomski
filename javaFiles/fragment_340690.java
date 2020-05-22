<script>
function doChange() 
{
    var val = document.getElementById("mydropdown").value;
    var e = document.getElementById("txtName");
    e.value = val;
}
</script>
<form>
<select name="mydropdown" id="mydropdown" onchange="doChange()">
<option value="IMEINumber1">Samsung</option>
<option value="IMEINumber2">Nokia</option>
<option value="IMEINumber3">Motorola</option>
</select>
<br/>
<input type="text" name="txtName" id="txtName" value="defualt" >