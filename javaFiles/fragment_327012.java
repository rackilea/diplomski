<script>
    var req = new XMLHttpRequest();
    req.onreadystatechange = function() {
        if (req.readyState == 4) {
            var data = req.responseText;
            //HANDLE RESPONSE HERE;
        }
    }
    req.open('GET', 'servletName', true);
    req.send(null);
</script>