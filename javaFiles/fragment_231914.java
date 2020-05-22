<script>
    $(function() {
        $.ajax({'url': '/signin', statusCode: {
            280: function(response) {
                window.location = response;
            }
        }});
    });
</script>