<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="row">
    <div class="twelve columns">
        <h1>${genForm.getUserFriendlyTypeName()}</h1>

        <a href="${genForm.getCreateLink()}" class="btn_styled">Create</a>
        <table class="border">
            <thead>
                <tr>
                    <c:forEach var="col" items="${genForm.getColumns()}">
                        <th>${col}</th>
                    </c:forEach>
                    <!-- Add two more for delete and edit -->
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <c:if test="${genForm.resultsSize() == 0}">
                <tr colspan="${genForm.getNumberOfFields()}">
                    <td><spring:message code="common.crud.norecords" text="common.crud.norecords"/></td>
                </tr>
            </c:if>
            <c:if test="${genForm.resultsSize() > 0}">
                <c:forEach var="row" begin="0" end="${genForm.resultsSize() - 1}">
                    <tr>
                        <c:set var="edit" value="?" />
                        <c:forEach var="column" begin="0"
                            end="${genForm.getNumberOfFields() - 1}">
                            <td>${genForm.getDataAt(row, column)}</td>
                            <c:set var="edit"
                                value="${edit}${genForm.getJavaFieldNameAt(column)}=${genForm.getDataAt(row, column)}&" />
                        </c:forEach>
                        <!-- Add delete and edit buttons -->
                        <th><a id="edit-row" class="btn_styled"
                            href="${genForm.getEditLink()}${edit}"><spring:message
                                    code="common.button.edit" text="common.button.edit" /></a></th>
                        <th><a id="delete-row" class="btn_styled"
                            href="${genForm.getDeleteLink()}?id=${genForm.getId(row)}"><spring:message
                                    code="common.button.delete" text="common.button.delete" /></a></th>
                    </tr>
                </c:forEach>
            </c:if>

        </table>
    </div>
</div>