<select>
    <option th:each="state : ${T(com.mypackage.Ticket.State).values()}"
            th:value="${state}"
            th:text="${state}">
    </option>
</select>