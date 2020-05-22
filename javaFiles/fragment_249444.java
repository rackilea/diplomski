function myHelpFunction() 
{
    var numbers = [1,2,3,4,5,6,7,8,9,10];
    var i;

    for(i=1; i< 11; i++)
    {
        document.getElementById("help_cell" + i).style.backgroundColor = "lightgray";
    }
}