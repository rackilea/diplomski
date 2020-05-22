<table  style="width:100%; border: 1px solid #dddddd; font-family: Times New Roman, Times, sans-serif;"> 
  <tr>
        <th>Loan Type</th><th>Loan Amount</th><th>Interest Rate</th><th>Loan Repayment Date</th><th>Tenor</th><th>Proposed Limit</th><th>Approved Limit</th>
  </tr>
    #set($columns = ["loanType", "loanAmount", "interestRate", "loanRepaymentDate", "tenor", "proposedLimit", "approvedLimit"])
    #foreach ($subMap in $Map.values())
    <tr>
        #foreach ($column in $columns)
            <td>$subMap.get($column)</td>
        #end
    </tr>
    #end
</table>