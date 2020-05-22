<div th:each="certs : ${certificateProgrammes}">
  <form th:if="${certs.flag == 'TRUE'}">
    .
    .
    .
  </form>
</div>