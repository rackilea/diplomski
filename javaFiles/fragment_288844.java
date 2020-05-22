<table>
     <tr th:each="row,iteration : ${timesheet.timesheetRow}">
         <td>
              <input type="hidden" th:field="*{timesheetRow[__${iteration.index}__].id}"/>
              <input type="text" th:field="*{timesheetRow[__${iteration.index}__].projectId}" />
         </td> 
         <td>
         <span th:each="task,iteration2 : ${row.timesheetTask}">
              <input type="hidden" th:field="*{timesheetRow[__${iteration.index}__].timesheetTask[__${iteration2.index}__].id}"/>
              <input type="text" th:field="*{timesheetRow[__${iteration.index}__].timesheetTask[__${iteration2.index}__].work}"/>

         </span>
         </td>
     </tr>
</table>