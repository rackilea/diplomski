<script>
$(document).ready(function (){
    $('#header-notif-icon-trigger').click();
    $('#live-events-trigger').click();
    // show kone ge widget if not visited
        $(window).load( function () {
             var hackathon_visit_cookie = readCookie('fintech_valley_hackathon_cookie');
             if (!hackathon_visit_cookie) {
                $('#custom_hackathon_widget').show();
             }
        });
        $(document).on('click', '#custom_hackathon_widget .hack-link', function(e) {
            createCookie('fintech_valley_hackathon_cookie', 'true', 180);
            $('#custom_hackathon_widget').fadeOut('slow');
        });
});
</script>