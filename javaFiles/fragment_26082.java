<!-- This adds the proper namespace on the generated SVG -->
function AddNamespace(){
var svg = jQuery('#chart_div svg');
svg.attr("xmlns", "http://www.w3.org/2000/svg");
svg.css('overflow','visible');
}
<!-- This generates the google chart -->
google.setOnLoadCallback(drawChart);
             function drawChart() {
             var container = document.getElementById('chart_div');
             var chart = new google.visualization.Timeline(container);
             var dataTable = new google.visualization.DataTable();

             dataTable.addColumn({ type: 'string', id: 'President' });
             dataTable.addColumn({ type: 'date', id: 'Start' });
             dataTable.addColumn({ type: 'date', id: 'End' });
             dataTable.addRows([
             [ 'Washington', new Date(1789, 3, 30), new Date(1797, 2, 4) ],
             [ 'Adams',      new Date(1797, 2, 4),  new Date(1801, 2, 4) ],
             [ 'Jefferson',  new Date(1801, 2, 4),  new Date(1809, 2, 4) ],
             [ 'Madison', new Date(1809, 2, 4), new Date(1817, 2, 4) ],
             [ 'Monroe',      new Date(1817, 2, 4),  new Date(1825, 2, 4) ],
             [ 'Quincy Adams', new Date(1825, 3, 30), new Date(1829, 2, 4) ],
             [ 'Jackson',      new Date(1829, 2, 4),  new Date(1837, 2, 4) ],
             [ 'Van Buren', new Date(1837, 2, 4), new Date(1841, 2, 4) ],
             [ 'Harrison',      new Date(1841, 2, 4),  new Date(1841, 3, 4) ],
             [ 'Tyler', new Date(1841, 3, 4), new Date(1845, 2, 4) ]]);

             google.visualization.events.addListener(chart, 'ready', AddNamespace);
             chart.draw(dataTable);
             }
 <!-- @cloudformatter calls to render the SVG -->

 <!-- Convert the SVG to PDF and download it -->
 var click="return xepOnline.Formatter.Format('JSFiddle', {render:'download', srctype:'svg'})";
 jQuery('#buttons').append('<button onclick="'+ click +'">PDF</button>');
 <!-- Convert the SVG to PNG@120dpi and open it -->
 click="return xepOnline.Formatter.Format('JSFiddle', {render:'newwin', mimeType:'image/png', resolution:'120', srctype:'svg'})";
 jQuery('#buttons').append('<button onclick="'+ click +'">PNG @120dpi</button>');
 <!-- Convert the SVG to JPG@300dpi and open it -->
 click="return xepOnline.Formatter.Format('JSFiddle', {render:'newwin', mimeType:'image/jpg', resolution:'300', srctype:'svg'})";
 jQuery('#buttons').append('<button onclick="'+ click +'">JPG @300dpi</button>');