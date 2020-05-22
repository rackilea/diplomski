$(function () {
    $("[name='Hello']").change(function () {
      alert($(this).val());
      if ($(this).val() != "") {
        $("form").submit();
      }
    });
  })

  function ClickMe() {
    $(".Hello").click();
  }