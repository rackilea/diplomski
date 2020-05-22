<table>

    <c:forEach items="${auditBudgetData.auditBudgetTierOneList}" var="auditBudgetTierOne" varStatus="tierOneCount">
            ** Some Code **     
        <c:forEach items="${auditBudgetTierOne.auditBudgetTierTwoList}" var="auditBudgetTierTwo" varStatus="tierTwoCount">
                ** Some Code ** 
                        <c:forEach items="${auditBudgetTierTwo.auditBudgetItemList}" var="auditBudgetItem" varStatus="budgetItemCount">


                            <input type="hidden" name="tierOneIndex"    id="tierOneIndex_${budgetItemCount.index}"        value="${tierOneCount.count}">
                            <input type="hidden" name="tierTwoIndex"    id="tierTwoIndex_${budgetItemCount.index}"        value="${tierTwoCount.count}">
                            <input type="hidden" name="budgetItemIndex" id ="budgetItemIndex_${budgetItemCount.index}"    value="${budgetItemCount.count}">

                            <tr class="rows" id="${budgetItemCount.index}"><td>click Here</td></tr>


    </table>