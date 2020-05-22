<script>
    $(document).ready(function(){
        var songsUrl = ["https://www.youtube.com/watch?v=BdRmjO04kH8", "https://www.youtube.com/watch?v=y7P9UWpHpMs", "https://www.youtube.com/watch?v=ES0oYC0hyD8"];
        $.each(songsUrl, function(index, value){

        var splitLink = value.split('watch?v=')
        var embedLink1 = splitLink.join("embed/")
            $("#result").append(index + ": " + embedLink1 + '<br>');
        });
    });
</script>


<body>
    <div id="result"></div>
</body>