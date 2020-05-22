eventClick: function(calEvent, jsEvent, view) {

    myClick.javaApp(calEvent.title, jsEvent.pageX, jsEvent.pageY, view.name);

    // change the border color just for fun
    $(this).css('border-color', 'red');

};