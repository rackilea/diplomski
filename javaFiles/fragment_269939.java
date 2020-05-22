public native void call()/*-{

    $wnd.onkeypress = GetChar;

     function GetChar (event)
     {
        var key = event.keyCode;

        var bb = event.target.nodeName;

             if(key==8 && bb=="BODY")
                {
                    var x= window.confirm("Are you sureyou want to leave the page");

                    if (x==true)
                            {
                                window.history.back();
                            }
                    else if(x==false)
                            {

                                return false;
                            }
                }
        }                   
}-*/;