<script>
    function jsp() {
        document.write('<%= new java.util.GregorianCalendar().getTime().toString() %>');
        // or any other JS function you may want to use
    }
</script>