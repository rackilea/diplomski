<c:forEach var="e" items="${entry}">
  <h3>For <c:out value="${e.key}"/></h3>
    <table>
      <thead>
            <tr>
                <th>Machine Name</th>
                <th>T2_95</th>
                <th>T2_99</th>
                <th>Syncs</th>
                <th>Syncs Behind</th>
                <th>Average</th>
            </tr>
        </thead>
        <tbody>
          <c:forEach var="m" items="${e.value}">
            <tr>
              <td>${m.machineName}</td>
              <td>${m.t2_95}</td>
              <td>${m.t2_99}</td>
              <td>${m.syncs}</td>
              <td>${m.syncsBehind}</td>
              <td>${m.average}</td>
             </tr>
           <c:ForEach>
        </tbody>
    </table>
</c:forEach>