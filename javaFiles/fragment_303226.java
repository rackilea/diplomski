<script>
    var secondsBeforeExpire = ${pageContext.session.maxInactiveInterval};
    var timeToDecide = 15; // Give client 15 seconds to choose.
    setTimeout(function() {
        alert('Your session is about to timeout in ' + timeToDecide + ' seconds!')
    }, (secondsBeforeExpire - timeToDecide) * 1000);
</script>