<script>
    <c:if test="${not empty message}">
        window.onload = function() {
            alert('${message}');
        }
    </c:if>
</script>