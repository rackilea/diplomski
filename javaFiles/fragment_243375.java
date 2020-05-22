<c:if test="${!empty REPORTED_WORD_LIST}">
        <form method="post" action="seeReportedWordsOneByOne.html">

            <select name="fityma" onchange="submit()">
                <c:forEach items="${REPORTED_WORD_LIST}" var="rep">
                    <option value="${rep.german}">${rep.german}</option>
                </c:forEach>
            </select>


        </form>
</c:if>