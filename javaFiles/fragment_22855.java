$(document).ready(function(){
    $(document).on("click", "#next", function(){
        alert("reached jquery")
        window.location.href = "/nextpage";
    });
});