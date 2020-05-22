<select style="float: none;margin: 0 0 0 30px;" name="partie" id="select_partie">
    <s:if test='parties != null'>
        <s:iterator value="equipesParties[%{#cpt.index}]" var="partie">
            <option <s:if test='#partie.id == gallery.partie.id'>
                        selected="selected"
                    </s:if> 
                    value="<s:property value='#partie.id' />">
                <s:property value="#partie.gameName" />
            </option>
        </s:iterator>
    </s:if>
</select>