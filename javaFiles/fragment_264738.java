xmlhttp.onreadystatechange=function()
{
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
  {
document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
  }
}