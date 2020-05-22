<select id="year" name="year">
            <c:forEach begin="0" end="116" var="val">
                <c:set var="decr" value="${2016 - val}"/>
                <option value="${decr}" ${birthYear == decr ? "selected='selected'": ''}>${decr}</option>
            </c:forEach>
</select>