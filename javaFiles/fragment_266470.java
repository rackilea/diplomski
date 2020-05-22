success: function (data)
{
    if (data.estatus === "OK")
    {
        setInterval(function(){ 
            document.location.href = 'acceso.acc'; //here is some magic.
        }, 3000);
    } else {
        //error message
    }
}