$.ajax({
    url: 'url',
    type: 'POST', //Change this base on your requirement
    data: { 'data', 'some data if you need' },
    success: function (data) {
      var lineChartData = {
            labels: ["January", "February", "March", "April", "May", "June", "July", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"],
            datasets: [
                {
                    label: "Data set 1",
                    fillColor: "rgba(220,220,220,0.2)",
                    strokeColor: "rgb(23,127,255)",
                    pointColor: "rgb(23,127,255)",
                    pointStrokeColor: "#fff",
                    pointHighlightFill: "#fff",
                    pointHighlightStroke: "rgba(220,220,220,1)",
                    data: [data1, data2, data3]
                }
            ]

        }

        var options =
        {
            showTooltips: true,
            onAnimationComplete: function () { this.showTooltip(this.datasets[0].points, true); render(); },
            tooltipEvents: [],
            responsive: true,
            scaleFontColor: "#5BC236",
            scaleColor: "#000"
        }

        var ctx = document.getElementById("graph1").getContext("2d");
        var chart = new Chart(ctx).Line(lineChartData, options);
    }

function render() {
    var url = document.getElementById("graph1").toDataURL();
    document.getElementById("url1").src = url;
}