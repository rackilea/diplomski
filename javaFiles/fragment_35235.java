<form th:object="${workdayForm}" th:action="@{/addworkday}">
  <!-- table headers -->
  <tr th:each="workdayCommand, i : ${workdayForm.workdayCommand}">
      <td><input type="text" class="form-control" placeholder="Enter hours" th:field="*{workdayCommands[__${i.index}__].hoursWorked}"></td>
      <td><input type="text" class="form-control" placeholder="Enter payment" th:field="*{workdayCommands[__${i.index}__].advancePayment}"></td>
      <td><input type="hidden" th:field="*{workdayCommands[__${i.index}__].employeeId}"/></td>
  </tr>
  <!-- table footers -->
</form>