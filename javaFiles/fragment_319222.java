$(window).scroll(function () {
    //get the window scrollTop on scroll
    var st = $(window).scrollTop();
    /* we use each() to iterate on every section and 
      check if the offset position is in relative condition to the
      scrollTop value  
    */
    $('#contents section').each(function (index) {
        var offsetTop = $(this).offset().top,
            h = $(this).height();
        //this condition satisfies that this section is currently on the viewport
        if (st >= offsetTop && st < offsetTop + h) {
           /*find the nav <a> that has the same index to this section
           currently on the viewport and
           show its border-bottom by setting its width.
           */
            $('nav a').eq(index).css({
                'border-bottom-width': '3px'
            });
        } else {
            //hide the border-bottom
            $('nav a').eq(index).css({
                'border-bottom-width': '0'
            });
        }
    });
}).trigger('scroll');