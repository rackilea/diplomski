<div th:id="${ticket.ticketId}" th:if="${#strings.toString(ticket.ticketStatus)} == 'CANCELED'">
    <script th:inline="javascript">
        /*<![CDATA[*/ 
        $(function() {
            yourFunction([[${ticket.ticketId}]]);
         });
        /*]]>*/
    </script>
</div>