function myHelpFunction(link) 
{
    var numbers = [1,2,3,4,5,6,7,8,9,10];
    var i;

    for(i=1; i< 12; i++)
    {
        if(link >= 1 && link <=6)
        {
            document.getElementById("help_cell" + link).style.backgroundColor = "#FF0004";
        }
        if(link == 7 || link ==8)
        {
            document.getElementById("help_cell" + link).style.backgroundColor = "#FF7F00";
        }
        if(link == 9 || link ==10)
        {
            document.getElementById("help_cell" + link).style.backgroundColor = "#709F32";
        }

        document.getElementById("help_cell" + i).style.backgroundColor = "lightgray";
    }
}