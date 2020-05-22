<style>
    .green {
        color: green;
    }

    .red    {
        color: red;
}
</style>




<table width="500px" border = "1" cellpadding="1"> 

    <tr> 
        <th>BeamLines</th> 
        <th>Status(1=Being Used)</th> 
    </tr> 

    <c:forEach var="country" items="${bs.beam_CurrentStatus()}">

        <c:choose>
            <c:when test="${country.value == 'OFF'}">
            <tr> 
                <td class="green"> ${country.key} </td> 
                <td class="green"> ${country.value} </td> 
            </tr> 

            </c:when>
            <c:otherwise>
            <tr> 
                <td class="red"> ${country.key} </td> 
                <td class="red"> ${country.value} </td> 
            </tr> 
            </c:otherwise>
        </c:choose>

    </c:forEach> 

</table>