$.ajax({
    url:      "/myscripts/myserverscript",
    type:     "POST",
    data:     {
       foo: "bar"
    },
    dataType: "text",
    beforeSend: function(xhr){
        // display a progress animation
    },
    complete: function(xhr, status){
        // hide the animation
    }
    ...
});