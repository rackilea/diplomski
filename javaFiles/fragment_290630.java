function disablefield()
{
if ( document.getElementById('name').value == '' ||  document.getElementById('name').value == null){
document.getElementById('name').disabled = true;
}
}