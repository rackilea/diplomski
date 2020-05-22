$('[data-toggle="toggle"]').change(function(){
    // cache element reference
    let $ele = $(this).parents().next('.hide');
    // toggle element
    $ele.toggle();
    // hide remaining 
    $('.hide').not($ele).hide();
});