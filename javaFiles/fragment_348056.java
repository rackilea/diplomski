$(function() {
  var $chk = $("#grpChkBox input:checkbox");
  var $tbl = $("#someTable");
  var $tblhead = $("#someTable th");

  $chk.prop('checked', true);

  $chk.click(function() {

    //Split the value of name
    var names = $(this).attr("name").split(",");

    //Loop thru each name
    $.each(names, function(index, value) {
      var colToHide = $tblhead.filter("." + value);
      var index = $(colToHide).index();
      $tbl.find('tr :nth-child(' + (index + 1) + ')').toggle();
    });

  });
});