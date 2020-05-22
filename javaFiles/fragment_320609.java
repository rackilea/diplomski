//Picture upload
$(function() {
  // This is a better way of selecting the input field
  $("input[name^=file]").change(function() {
    if (this.files && this.files[0]) {
      var reader = new FileReader();
      reader.onload = imageIsLoaded;
      reader.readAsDataURL(this.files[0]);

      // This is what you should do
      $('#photo_name').val(this.files[0].name);
    }
  });
});

function imageIsLoaded(e) {
  $('#myImg').attr('src', e.target.result);
};