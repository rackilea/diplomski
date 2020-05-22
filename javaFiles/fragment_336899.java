<script>
    function getData() {
        $.post("MyServlet", {
            query : "Wolf of wall street",
            choice : "M"
        }, function(response) {
            alert("hello" + JSON.stringify(response));
        });
    }
   </script>