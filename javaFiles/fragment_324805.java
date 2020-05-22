function downloadPdf() {
    "use strict";

    //  get the graphics global container
    var $body_clone = $('#pdf_container');
    // get the SVGs
    var $svgs = $('.graph_container svg');
    var $svg;
    var promises = [];

    for (var i=0; i<$svgs.length; i++) {
        $svg = $svgs.eq(i);

        // convert the SVGs to images srcs
        promises.push(svgAsPngUri($svg[0]));
    }

    $.when.apply(null, promises).then(function() {
    var img_scrs = Array.prototype.slice.call(arguments);
    var $img;

        for (var i=0; i<$svgs.length; i++) {
            $svg = $svgs.eq(i);
            $img = $(new Image());
            $img.attr("src", img_scrs[i]);
            // substitute the SVGs with the image
            $svg.replaceWith(imgs[i]);
        }

        var $body_clone = $('#pdf_container');
        var body = $body_clone[0].outerHTML;
        $('#pdfBody').val(body);

        // send to the server the HTML of the container of all images
        $('#pdfForm').submit();

        // get all images
        var $imgs = $('.graph_container img:not(.waiting)');
        var $img;

        for (var i=0; i<$imgs.length; i++) {
            $img = $imgs.eq(i);
            // replace image with empty svg
            $img.replaceWith('<svg></svg>');
        }

        // repopulate the graphs as you did at the page load
        grafic();
    });
}