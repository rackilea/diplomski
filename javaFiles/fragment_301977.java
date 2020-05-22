<script>
    var sellerCodes = {};
    <c:forEach items="${sellerCodeList}" var="entry">
        sellerCodes['${entry.key}'] = '${entry.value}';
    </c:forEach>
    // you can now use sellerCodes in your JS code as a map.
</script>