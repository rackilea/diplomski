// Say that $('#select-doubles option:selected').val() is equal to 21.9
var Double = parseInt($('#select-doubles option:selected').val(), 10);
// Double is now equal to 21, as you parsed it to an integer value.
// But if you use parseFloat instead :
Double = parseFloat($('#select-doubles option:selected').val());
// Double is now equal to 21.9