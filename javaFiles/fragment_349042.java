function generateURLX()
{
var partx = document.getElementById('partx').value;
var party = document.getElementById('party').value;
var urlx = "https://example.com/"+partx+"/"+party+".html";
document.getElementById('resultx').innerHTML = urlx;
}