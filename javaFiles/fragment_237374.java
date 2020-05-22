<select name="foo">

    <s:iterator value="myMapOfMaps" var="currentEntry">
        <s:if test="%{#currentEntry.value instanceof java.util.Map}">

            <optgroup label="<s:property value='%{#currentEntry.key}'/>">
                <s:iterator value="#currentEntry.value" var="innerEntry">

                    <option value="<s:property value='%{#innerEntry.key}'/>">
                        <s:property value='%{#innerEntry.value}' />
                    </option>

                </s:iterator>
            </optgroup>

        </s:if>
        <s:else>

            <option value="<s:property value='%{#currentEntry.key}'/>">
                <s:property value='%{#currentEntry.value}' />
            </option>

        </s:else>
    </s:iterator>

</select>