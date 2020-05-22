#foreach( $reportGroup in ${orgReport.reportGroupList})
    <br><tr>
        <a href="periodHandler?period=${reportGroup.ReportGroupName}">
            ${reportGroup.ReportGroupName}</a>
    </tr><br>
 #end