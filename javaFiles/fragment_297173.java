$.ajax({
            type: 'POST',
            dataType: 'json',
            contentType: 'application/json',
            url: '/organizer/api/saveee?id=10',
            data: JSON.stringify(fieldBean.data),
            success: function(result) {
                //TODO
            }
        })