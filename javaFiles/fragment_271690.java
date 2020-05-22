function update_coordinate_javascript(msg)
{
    var mycords = msg.split(",");
    for(var i=0; i<mycords.length; i++)
    {
       xyscript.push(mycords[i]);
    }
}