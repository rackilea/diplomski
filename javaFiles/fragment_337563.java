$('input, select').each(function () {
            var el_name = $(this).prop('name');
            var el_value = $(this).val();
            if (Browser.Version() < 8) {
                scanApplet.addUploadParameter(el_name, el_value);
            } else {
                $('#scanApplet')[0].addUploadParameter(el_name, el_value);
            }
        });