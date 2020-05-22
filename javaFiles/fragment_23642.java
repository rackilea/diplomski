$("#Temp1").click(function() {
  $("#Temp4").css("background-color", "");
  $("#Temp3").css("background-color", "");
  $("#Temp2").css("background-color", "");
  $("#Temp1").css("background-color", "red");
  $("#temp").text(1);
});

$("#Temp2").click(function() {
  $("#Temp4").css("background-color", "");
  $("#Temp3").css("background-color", "");
  $("#Temp2").css("background-color", "yellow");
  $("#Temp1").css("background-color", "red");
  $("#temp").text(2);
});

$("#Temp3").click(function() {
  $("#Temp4").css("background-color", "");
  $("#Temp3").css("background-color", "green");
  $("#Temp2").css("background-color", "yellow");
  $("#Temp1").css("background-color", "red");
  $("#temp").text(3);
});

$("#Temp4").click(function() {
  $("#Temp4").css("background-color", "orange");
  $("#Temp3").css("background-color", "green");
  $("#Temp2").css("background-color", "yellow");
  $("#Temp1").css("background-color", "red");
  $("#temp").text(4);
});