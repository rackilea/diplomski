<script>
    $(document).ready(function(){
       if (!$(<%= request.getAttribute(Constants.ERROR)%>).isEmptyObject()) {
        alert("Veuillez confirmer mot de passe et le username");
       }
    });


</script>