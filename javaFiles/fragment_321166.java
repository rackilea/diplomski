<s:iterator value="myList" status="ctr">
    <s:select cssClass="login-textbox" 
              cssStyle="width:130px" 
                  list="#masterColDO.validation" 
                  name="chngdColumnValues" 
                    id="%{'columnId' + #ctr.index}" />
</s:iterator>