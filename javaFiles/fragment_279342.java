[#assign cpathx = ctx.contextPath]
[#assign url = model.getUrl() /] 
var field = $('#key').val();
var calin = $('#calendarIni').val();
var calfin = $('#calendarFin').val();
var pais = selected.join();
var url = '${cpathx}${url}?paises='+pais+'&palabra='+field+'&calendarini='+calin+'&calendarfin='+calfin;
    jQuery.post(url ,function(data) {
    jQuery('#ajax').html(data);
  });