jQuery(function($) {
    $('#rightcol img').draggable({
        helper: 'clone'
    });

    var dropProps = {
        accept: "img",
        activeClass: 'active',
        hoverClass: 'hover',
        drop: function(ev, ui) {
            console.log(ui);
            var $im = $(ui.draggable);
            var $row = $('<tr />').append(
                $('<td />').html($im.attr('id'))
            ).append(
                $('<td />').html($im.attr('title'))
            ).append(
                $('<td />').append($im.clone().attr('id', null))
            ).droppable(dropProps);
            $(this).after($row);
        }
    };

    $('#leftcol table tbody tr').droppable(dropProps);
});