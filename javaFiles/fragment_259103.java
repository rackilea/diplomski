/**
* Gets any CSS color value and returns an array of variation
* With objects that holds the variations rgb values.
*
* @param   String  cssColor  The CSS color
* @param   Number  vars      How Many variation
* @return  Array             Array of objects - first is the original rgb.
*/

function getColorReturnVar(cssColor, vars) {
    results_rgb = [];
    results_hsl = [];
    inc = 0;
    $test = $("<div />").css({ 
       background:cssColor, 
       width:'1px', 
       height:'1px' 
    });
    $('body').append($test);
    rgb = $test.css('backgroundColor');
    $test.remove();
    rgb = rgb.replace(/rgb\(|rgba\(| |\).*/gi,"").split(',');
    results_rgb[0] = {r:parseInt(rgb[0]),g:parseInt(rgb[1]),b:parseInt(rgb[2])};
    results_hsl[0] = rgbToHsl(results_rgb[0].r, results_rgb[0].g, results_rgb[0].b);
    if (results_hsl[0].l < 0.5) 
       inc = Math.floor(((1-results_hsl[0].l)/(vars+3)) * 100) / 100;
    else 
       inc = (Math.floor(((results_hsl[0].l-0)/(vars+3)) * 100) / 100)*-1;
    for (var i=1; i< vars+1; i++) {
        results_hsl[i] = { h:results_hsl[i-1].h,s:results_hsl[i-1].s,l:results_hsl[i-1].l + inc };
        results_rgb[i] = hslToRgb(results_hsl[i].h,results_hsl[i].s,results_hsl[i].l);
    }
    return results_rgb;
}