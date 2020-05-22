google.charts.load('current', {
  callback: drawChart,
  packages:['corechart']
});

function drawChart() {
  var data = new google.visualization.arrayToDataTable([
    ['Year', 'ONE', { role: 'style' } ],
    ['2010', 10, 'color: white'],
    ['2020', 14, 'color: gray'],
    ['2030', 16, 'color: yellow'],
    ['2040', 22, 'color: green'],
    ['2050', 28, 'color: red']
  ]);

  var options = {
    title: 'Revenue per Year',
    width: 500,
    height: 500,
    bar: {
      groupWidth: '95%'
    },
    legend: {
      position: 'none'
    },
    backgroundColor: {
      fill: 'transparent'
    },
    titleTextStyle: {
      color: 'red',
      fontSize: 24
    },
    vAxis: {
      textStyle: {
        color: '#FFF',
        fontSize: 24
      },
      slantedText: true,
      slantedTextAngle: 60
    },
    hAxis: {
      textStyle: {
        color: '#FFF',
        fontSize: 24
      },
      direction: -1,
      slantedText: true,
      slantedTextAngle: 60
    }
  };

  var view = new google.visualization.DataView(data);
  view.setColumns([0, 1, 2, {
    calc: 'stringify',
    role: 'annotation',
    sourceColumn: 0,
    type: 'string'
  }]);

  var container = document.getElementById('chart_div');
  var chart = new google.visualization.BarChart(container);

  // move annotations
  var observer = new MutationObserver(function () {
    Array.prototype.forEach.call(container.getElementsByTagName('text'), function(annotation) {
      // identify annotation -- could be tooltip label
      if ((annotation.getAttribute('text-anchor') === 'start') &&
          (annotation.getAttribute('fill') !== '#000000')) {
        var chartLayout = chart.getChartLayoutInterface();
        var annotationBounds = annotation.getBBox();
        var annotationPadding = 4;
        annotation.setAttribute('x',
          chartLayout.getXLocation(0) - annotationBounds.width - annotationPadding
        );
      }
    });
  });
  observer.observe(container, {
    childList: true,
    subtree: true
  });

  chart.draw(view, options);
}