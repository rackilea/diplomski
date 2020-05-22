function documentOnReady() {

var json =  
[ 
    {"dates":"24 feb","visitors":"5"}, 
    {"dates":"25 feb","visitors":"21"}, 
    {"dates":"26 feb","visitors":"14"}, 
    {"dates":"27 feb","visitors":"45"}, 
    {"dates":"28 feb","visitors":"20"}, 
    {"dates":"29 feb","visitors":"18"}, 
    {"dates":"01 mar","visitors":"9"}, 
    {"dates":"02 mar","visitors":"7"}, 
    {"dates":"03 mar","visitors":"42"}, 
    {"dates":"04 mar","visitors":"17"}, 
    {"dates":"05 mar","visitors":"15"}, 
    {"dates":"06 mar","visitors":"9"}, 
    {"dates":"07 mar","visitors":"15"}, 
    {"dates":"08 mar","visitors":"3"}, 
    {"dates":"09 mar","visitors":"3"}, 
    {"dates":"10 mar","visitors":"19"}, 
    {"dates":"11 mar","visitors":"15"}, 
    {"dates":"12 mar","visitors":"11"} 
] ;

    var plot_data = new Array(); 
    var plot_ticks = new Array(); 

    for (var i in json) { 
        i = parseInt(i); 
        plot_data.push([i, json[i].visitors]); 
        plot_ticks.push([i+0.5, json[i].dates]); 
    } 

    $.plot($("#placeholder"),  
         [ 
            {"data": [[0, 0]]},  
            {"data": [[0, 0]]},  
            {"data": [[0, 0]]},  
            {"data": [[0, 0]]},  
            {"data": [[0, 0]]},  
             { 
                 label: "Last 20 days visits", 
                 bars: {"show": "true"}, 
                 data: plot_data 
             } 
         ], 
        { 
             xaxis: { 
               ticks: plot_ticks 
            } 
         } 
     ); 
}
$(document).ready(documentOnReady);