<script>
    $(document).ready(function(event) {
    event.preventDefault();
    var pads = $('ul.pagination').children();
    pads.click(function() {
        $.ajax({
            type: 'GET',
            url : "/hospital/symptoms",
            data: {rows: parseInt($('#select').text()), page: parseInt($(this).text())},
        });
    });
    });
</script>