$('.submit_forgotPassword').click(function(e){
    e.preventDefault();
    var frm = $(this).parents('form');
    frm.attr('action', 'login/forgotPassword');
    frm.submit();
});