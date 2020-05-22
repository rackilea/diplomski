<div class="row" th:each="hivRisk, stat : ${hivRiskList}" th:if="${stat.even}">
   <div class="col-md-6" th:with="leftRisk=${hivRiskList.get(stat.index)}">
      <div class="checkbox checkbox-styled">
         <label>
         <input type="checkbox" value="-1" th:value="${leftRisk.id}"/>
         <span th:text="${leftRisk.name}">HIV Risk</span>
         </label>
      </div>
   </div>
   <div class="col-md-6" th:if="${stat.index + 1 &lt; hivRiskList.size()}" th:with="rightRisk=${hivRiskList.get(stat.index + 1)}">
      <div class="checkbox checkbox-styled">
         <label>
         <input type="checkbox" value="-1" th:value="${rightRisk.id}"/>
         <span th:text="${rightRisk.name}">HIV Risk</span>
         </label>
      </div>
   </div>
</div>