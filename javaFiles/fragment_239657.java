<tr th:each="mentor : ${mentorsList}">
    <a th:href="${'/edit-mentor/' + mentor.id}"/>
        <td th:text="${mentorStat.count}">1</td>
        <td th:text="${mentor.name}">Adam</td>
        <td th:text="${mentor.surname}">Nowak</td>
        <td th:text="${mentor.email}">example@gmail.com</td>
    </a>
</tr>