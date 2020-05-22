function resize_sidebar() {
    var h = $('#wrap').height();
    $('#sidebar-wrapper').height(h);
}

resize_sidebar();

​$(window).on('resize', function(){
    resize_sidebar();
   ...do something else...
}