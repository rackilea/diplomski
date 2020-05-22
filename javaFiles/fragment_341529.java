function showInput(message, callback) {
    // display dialog
    // ...

    callback($("input").val()); // this should be returned to getInput after Submit is clicked
});

showInput("Enter a  value:", function(x) {
    // do something now 
});