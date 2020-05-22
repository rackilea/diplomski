$(document).ready(function() {
  $('#selectCampagn').change(function() {
   var val = $('#selectCampagn').val();
    $('input[name=campaignId]').val(val);
  });
});