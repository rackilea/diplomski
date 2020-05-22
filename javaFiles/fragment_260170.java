<form id="myForm">
        <s:select label="Select a month" 
              headerKey="-1" 
              headerValue="Select Month"
              list="#{'1':'Jan', '2':'Feb', '3':'Mar', '4':'Apr'}" 
              name="yourMonth" 
              value="2" 
              id="selectedMonth"/>
              <input type="text" name="par1" value="OOOOOOO1"/>
              <input type="text" name="par2" value="OOOOOOO2"/>

              <input type="submit" value="Submit"  onclick="myAjaxFunction();"/>    
    </form>
    <s:url var="remoteurl" action="jsontable" >
        <s:param name="par1">Kshitij</s:param>
    </s:url>

    <sjd:grid id="gridtable"
                formIds="myForm"
                caption="Customer Examples"
                dataType="json"
                href="%{remoteurl}"
                pager="true"
                gridModel="gridModel"
                rowList="10,15,20"
                rowNum="15"
                rownumbers="true">
                <sjd:gridColumn name="id" index="id" title="ID" width="200"/>
                <sjd:gridColumn name="name" index="name" title="Name" sortable="true" />
                <sjd:gridColumn name="country" index="country" title="Country" />
                <sjd:gridColumn name="city" index="city" title="City" />
                <sjd:gridColumn name="creditLimit" index="creditLimit" title="Credit Limit" />
    </sjd:grid>