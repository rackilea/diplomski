$('document').ready(function(){  
    //initialize quickflip  
    $('#flip-container').quickFlip();  

    $('#flip-navigation li a').each(function(){  
        $(this).click(function(){  
            $('#flip-navigation li').each(function(){  
                $(this).removeClass('selected');  
            });  
            $(this).parent().addClass('selected');  
            //extract index of tab from id of the navigation item  
            var flipid=$(this).attr('id').substr(4);  
            //Flip to that content tab  
            $('#flip-container').quickFlipper({ }, flipid, 1);  

            return false;  
        });  
    });  
});