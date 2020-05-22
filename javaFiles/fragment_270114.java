function validateForm()
                {
                var x=document.getElementsByName('name1')[0].value;
                if (x.trim().length<=4)
                  {
                    document.getElementById("error").innerHTML="atleast 4 letters required in name";
                    return false;
                  }
                }