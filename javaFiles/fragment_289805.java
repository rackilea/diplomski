$(function() {
                $("#file_upload").uploadify({
                    'formData'      : {'fileName' : 'hello', 'fileNum' : 1},
                    'swf'           : 'uploadify.swf',
                    'uploader'      : '../upload',
                    'onUploadStart' : function(){
                        $("#file_upload").uploadify('settings','formData' ,{'fileNum': $('#fileNum').val()}); // to change value dynamically
                    }
                });
            });