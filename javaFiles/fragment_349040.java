function generateURL()
{
var part1 = document.getElementById('part1').value;
var part2 = document.getElementById('part2').value;
var url = "https://example.com/"+part1+"/"+part2+".html";
document.getElementById('result').innerHTML = url;
}