deleteRow : function() {
    $("input:checkbox:checked").each(bindContext(function(index, item) {
        var str = $(item).attr("id");
        str = str.substring(str.indexOf("_") + 1);

        $.ajax({
            url : '/Spring3HibernateApp1/delete/' + id, // id is your patvariable
            type : 'POST',
            data :  str // str must equal to employee json object
        });
        this.data.splice(str, 1);
        this.deleteTable();
        this.display();
    }, this));
},