<div th:each="stepEntry: ${map}"> // stepEntry now is each entry of your map. 
    <p th:text="${stepEntry.key}"></p> // this is the key value of the entry.
    <div th:each="member, iterStat : ${stepEntry.value}"> //this will iterate over the value (which is a list in this case) from the entry.
        <p th:text="${member.fname}"></p> //this prints the fname of each member in the list
    </div>
</div>