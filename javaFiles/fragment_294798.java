("#selectCategory").change(function(){
    var categoryId = $(this).val();
    $.ajax({
        type: 'GET',
        url: "/categories/" + categoryId,
        success: function(data){
            var slctSubcat=$('#selectSubcat'), option="";
            slctSubcat.empty();

            for(var i=0; i<data.length; i++){
                option = option + "<option value='"+data[i].id + "'>"+data[i].subcateogory_name + "</option>";
            }
            slctSubcat.append(option);
        },
        error:function(){
            alert("error");
        }

    });
});