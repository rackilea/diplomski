<%Integer value = (Integer)request.getAttribute("value");%>

    <script type="text/javascript">
    window.onload = function() {
    .
    .
    .
    var aa=+'<%=value%>';
    datapoints.push({x: new Date(2015, 03, 10), y: aa});
    chart.render();
    .
    .
    .
    </script>