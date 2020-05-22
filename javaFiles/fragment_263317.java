<c:forEach var="investorAcc" items="${listInvestorAcc}" varStatus="st">
   <form action="updateInvestorAcc">
      <input type="hidden" name="id" value="${investorAcc.id}"/>
      <tr>
          <td>${st.index + 1}</td>
          <td>${investorAcc.investor_code}</td>
          <td>${investorAcc.investor_name}</td>
          <td>
              <c:choose>
                 <c:when test="${investorAcc.sms_sub==1}">
                   <input type="checkbox" id="chk" name="chkSms" 
                        value="${investorAcc.sms_sub}" checked="checked"/>
                 </c:when>
                 <c:otherwise>
                     <input type="checkbox" id="chk" name="chkSms" 
                           value="${investorAcc.sms_sub}"/>
                 </c:otherwise>
              </c:choose><td> <!-- end of checkbox -->
          <td><input type="submit" value="Update"></td>
      </tr>
   </form> 
</c:forEach>