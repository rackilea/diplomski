<tr align="left" valign="top">
  <td>&nbsp;</td>
  <form action="searchOrdersAction.jsp" name="form" method="get">
    <td><input name="CustEmail" type="text" class="DataEntry" id="frm_input"></td>
    <td><select onchange="document.getElementById('frm_input').name=this.value">
          <option selected value="CustEmail">Customer Email</option>
          <option value="OrderID">Order ID</option>
        </select>
    </td>
    <td><input name="Submit" type="submit" class="SOBut" value="Go"></td>
  </form>
</tr>