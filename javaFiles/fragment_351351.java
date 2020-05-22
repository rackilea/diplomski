jQuery(function ($) {
    $(document).on('click', '.prev', function(){ // 'prev' is class of previous button
        var tabctrl = $(this).closest('form').find('.tabctrl');
        var currentItemHeader = $(tabctrl).find(".tabctrl-header li.active");
        $(currentItemHeader).prev().find('a').click();
    });
    $(document).on('click', '.next', function(){ // 'next' is class of next button
        var tabctrl = $(this).closest('form').find('.tabctrl');
        var currentItemHeader = $(tabctrl).find(".tabctrl-header li.active");
        $(currentItemHeader).next().find('a').click();
    });
});