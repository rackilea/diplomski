<s:select id="regionstate" name="state" list="stateMap">  
                 <s:iterator value="region" status="regionStatus">  
                     <optgroup label="%{name}">  
                             <s:iterator value="states" status="stateStatus">  
                                 <option value="%{id}"> %{name}</option>  
                             </s:iterator>  
                     </optgroup>  
               </s:iterator>
    </s:select>