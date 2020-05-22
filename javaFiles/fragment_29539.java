<th:block th:with="sdf = ${new java.text.SimpleDateFormat('dd/MM/yyyy HH:mm')}">      
    <div class="content" th:each="e : ${events}">
        <div class="info date" th:value="${e.datesCoordinates.created}? ${#dates.format(sdf.parse(e.datesCoordinates.created), 'dd/MM/yyyy HH:mm')}"></div>
        <div class="info operator" th:text="|${e.owner.first_name} ${e.owner.last_name}|"></div>
    </div>
</th:block>