$(document).ready(function() {
    $('.result-div').click(function() {
            $(this).fadeOut(1000).fadeIn(200);

         var currentClickedIndex = this.index();
   window.location.href='andPageToProcessThisIndex.jsp?idx = '+currentClickedIndex ;

    });
});