$.ajax({
        url: 'uploadwebcamimage.jsp',
        type: "POST",
        dataType: 'json', //set dataType as json i.e. response data format 
        data: {
            encodeimg: dataUrl,
            OwnerId: document.Clickpictures.OwnerId.value,
            OwnerPhone: document.Clickpictures.OwnerPhone.value,
            mobilepass: document.Clickpictures.mobilepass.value,
            emailpass: document.Clickpictures.emailpass.value,
            mypassword: document.Clickpictures.mypassword.value,
            mygroupuserid: document.Clickpictures.mygroupuserid.value

        },
        error : function(jqXHR, textStatus, errorThrown){ 
            alert(textStatus+' : '+ errorThrown);
        },
        success: function(response){
           alert(response.flag);
           $.each(response.list, function(key,value){
               alert(value);
           });
        }
    });