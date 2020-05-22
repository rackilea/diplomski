<ol >
    <li th:each="row,iterRow : ${rows}" th:class="'row ' +  ${row}"> <!-- iteration over rows -->
        <ol class="seats">
            <li class="seat" th:each="seat,iterSeat : ${seats}">  <!-- iteration over seats for each row -->
                <input type="checkbox" th:id="${iterRow.count} + ${seat}">
                <label th:for="${iterRow.count} + ${seat}"></label>
            </li>
        </ol>
    </li>
</ol>