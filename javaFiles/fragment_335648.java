com.ivb.module.home.pics.showDialogBox = function(nodeId, classNameId, obj) {

    // something ...

    var href = $(obj).find('a').data('href');
    makeAjaxRequest().success(function() {
        location.href = href;
    });
};