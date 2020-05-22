<script>
$(document).ready(function(){
if ( document.referrer == null || document.referrer.indexOf(window.location.hostname) < 0 ) {
   window.location.href = window.location.href + "?documentMode=" + document.documentMode;
}
});
</script>