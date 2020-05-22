function positionSidebar() {
    if ($('.container').first().innerWidth() > 750) {
        $('#sidebar').affix({});
    } else {
        $('#sidebar').removeAttr('data-spy');
    }
}

setInterval(positionSidebar, 300);