(function($){

$(function(){  //document.ready


    $("#xAxisList").on('change', function() {
       showAxis('x'); 
    });

function showAxis(coordinate){
var axisList = coordinate + "AxisList";
var v = document.getElementById(axisList);
selectedAxisType = v.options[v.selectedIndex].value;

var dataArray = new Array();
selectedChartType = "PieChart";    
var selectedChart = document.getElementById(selectedChartType);

var tr, td;
var table, tableBody;
var dropdown, opt, i;

table = document.createElement('TABLE');

dataArray = ["Years", "Seasons", "Months", "Weeks", "Days"];

table.setAttribute("id", "time"+axisList+"Table");
table.setAttribute("class", "time"+axisList+"Table");
table.width='100%';

tableBody = document.createElement('TBODY');
table.appendChild(tableBody);

dropdown = document.createElement("select");
dropdown.setAttribute("id", "time"+axisList);
tr = document.createElement('TR');
tableBody.appendChild(tr);

td = document.createElement('TD');
td.width='40%';
td.appendChild(document.createTextNode("Time selection on the basis of:"));
tr.appendChild(td);

opt = document.createElement("option");
opt.hidden="true";
dropdown.options.add(opt);

for (i=0; i<dataArray.length; i++){
    td = document.createElement('TD');
    opt = document.createElement("option");
    opt.text = dataArray[i];
    opt.value = dataArray[i];
    dropdown.options.add(opt);
    td.appendChild(dropdown);

    tr.appendChild(td);
}// END of Outer for loop
selectedChart.appendChild(table);
}// END of showAxis

      });

})(jQuery);