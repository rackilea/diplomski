$(document).ready(function() {
  $("#yourFormsId").submit(function() {
         $('input[name="number_of_yes"]').val(
            $('input:checked[type="radio"][value="yes"]').length);
  });
});