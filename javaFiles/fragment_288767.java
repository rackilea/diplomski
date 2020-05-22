$.ajax({
    type: "GET",
    url: "url",
    dataType: 'json',
    success: function(data){


        var timeArray = data.time;
        var costArray = data.cost;


     // First chart initialization
        chart1 = new Highcharts.Chart({
         chart: {
            renderTo: 'chart_1',
            height: 350,
         },
         title: {
            text: 'Ozone Trending'
         },
         xAxis: {
           categories: timeArray,
           labels: {
               rotation: -45,
               align: 'right'
           }
         },
         yAxis: [{
             opposite: true,
             title: {
                 text: 'Cost'

             },
             labels: {
                 style: {
                     color: '#dbf400'
                 }
             },plotOptions: {
                series: {
                    pointWidth: 20
                }
            }
         }],

         series: [ {
             name: 'Cost',
             data: costArray,

         }]
        });


    }

});