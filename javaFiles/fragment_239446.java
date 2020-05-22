Polymer({
......
convertFileInputToFormData: function(){
  regexp = /^[^[\]]+/;
  var fileInput = $('input[type="file"]');
  var fileInputName = regexp.exec( fileInput.attr('name') );
  // make files available
  var data = new FormData();
  jQuery.each($(fileInput)[0].files, function(i, file) {
      data.append(fileInputName+'['+i+']', file);
  });
  return data;
},
.......