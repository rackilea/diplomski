$('nav a').click(function () {
    /* click has no index argument compared to each() function 
    so we have to get it with index() */
    var index = $(this).index(),
        $target = $('#contents section').eq(index); // find the target section
    //animate scrolling to the target section
    $('html, body').stop(true, true).animate({
        scrollTop: $target.offset().top
    }, 'slow');
});