function validateForm()
         {
            var capacity=document.forms["createLabs"]["capacity"].value;
            var day=document.forms["createLabs"]["day"].value;
            var time=document.forms["createLabs"]["time"].value;
            var room=document.forms["createLabs"]["room"].value;

            if (capacity === undefined)
              {
                    alert("Capacity must be filled out");
                    document.createLabs.capacity.focus();
                    return false;
              }

                if(day === undefined)
             {
                    alert("Day must be filled out");
                    document.createLabs.day.focus();
                    return false;
             }

                 if(time === undefined)

             {
                    alert("Time must be filled out");
                    document.createLabs.time.focus();
                    return false;
             }

                 if(room === undefined)

             {
                    alert("Room must be filled out");
                    document.createLabs.room.focus();
                    return false;

            }

                if ( isNaN(capacity))
                {
                     alert("Please check - non numeric value!");
                    document.createLabs.room.focus();
                    return false;
                }

                    if ( isNaN(room))
                {
                     alert("Please check - non numeric value!");
                    document.createLabs.room.focus();
                    return false;
                }

                if(room === undefined)
            {
                    alert("Please check - non numeric value!");
                    document.createLabs.room.focus();
                    return false;
            }




                    var link2 = document.getElementById('submit');

                        link2.onclick = function ()     
                        {
                            if( confirm("Please fill in all the required fields") )
                            {
                                window.location.reload();
                            }
                            return false;
                        }


                            }