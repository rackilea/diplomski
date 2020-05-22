function downloadImage(divName,urlProduct){
$(document).ready(function(){
    $(divName).on('click', function(){
        onlyshowLoading();
        $.ajax({
            url: urlProduct,
            type: "POST",
            data: JSON.stringify({
                "lat": $('#latitude').val(),
                "lng": $('#longitude').val(),
                "date_info": $('#date_start').val() + ' to ' + $('#date_end').val(),
                'image_id': $("#dropdown:first-child").text().split(" / ")[1],
            }),
            dataType: 'json',
            cache: true,
            error: function(){
                AjaxOnError();
            },              
            success: function(data){
                AjaxOnSuccess();
                if (typeof ETa_adjusted  == "undefined" || ETa_adjusted  == null){
                    $("#ETrF_adjusted").hide();
                    $("#EToF_adjusted").hide(); 
                    $("#ETa_adjusted").hide();
                    $("#etrF_adj_download").hide();
                    $("#etoF_adj_download").hide();
                    $("#eta_adj_download").hide();
                } else{
                    $("#ETrF_adjusted").show();
                    $("#EToF_adjusted").show(); 
                    $("#ETa_adjusted").show();
                    $("#etrF_adj_download").show();
                    $("#etoF_adj_download").show();
                    $("#eta_adj_download").show();

                }
                var key = Object.keys(data);
                typeName = data[key]
                window.open(typeName.url, '_blank');                     
            }
        });        
    });
})