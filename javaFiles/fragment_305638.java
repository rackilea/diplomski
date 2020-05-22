for(int i=0; i<NoOfRecords.length;i++){
<tr>
    <td width="15%"> Transit Account & <%= acctId%>
    </td>
    <td width="15%"> <%=MultiModeConstants.GL_ACCT_NO%>
    </td>
    <td width="45%">
    <input type="text" id="multiModeAcctNo_<%=i%>" name="multiModeAcctNo_<%=i%>" desc="Multi Mode Transit Account Number" maxlength="9" class="body" size="9" tabindex="3" >
    </td>
    <td width="15%">
        Deposit
    </td>
    <td width="15%">
        $ <%= transactioAmount%>
    </td>
</tr>
}