$('#location').change(
        function() {
            $.getJSON("http://localhost:8181/appointment/agencies", {
                cityId : $(this).val(),
                ajax : 'true'
            }, function(data) {
                var html = '<option value="">--alege agentia--</option>';
                var len = data.length;
                for ( var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].nume + '">'
                            + data[i].nume + '</option>';
                }
                html += '</option>';
                $('#agency').html(html);
            });
        });