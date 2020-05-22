<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Add contact to Phone Book</h1>
</head>
<body>
  <form name="submitInfo" method="get" action="AddEntryServlet">
        First Name: <input type="text" name="firstName"/> <br/>
        <br/>
        Last Name: <input type="text" name="lastName"/> <br/>
        <br/>
        Area Code: <input type="number" name="areaCode"/> <br/>
        <br/>
        Phone Number: <input type="number" name="phoneNumber"/> <br/>
        <br/>
        <input type="submit" value="Submit" />

    </form>
</body>



<h1>Search for Contact in Phone Book</h1>
<body>

<%Object persons = request.getAttribute("persons"); %>

<br>
  <form name="searchInfo" method="get" action="SearchServlet">
        Search First Name: <input type="text" name="searchFirstName"/> <br/>
        <br/>

        <input type="submit" name="action" value="search" />

        </form>
</body>


</body>

<html>
<head>
<style> html, body { margin: 0; padding: 0; height: 100%; } </style>
    <script src="https://unpkg.com/ag-grid@15.0.0/dist/ag-grid.js"></script>

</head>
<body>
 <input type="text" id="quickFilterInput" placeholder="Type text to filter..."/>
<div id="myGrid" style="width: 100%; height: 100%;" class="ag-theme-fresh"></div>

    <script>

            var columnDefs = [
                {headerName: 'First Name', field: 'firstname'},
                {headerName: 'Last Name', field: 'lastname'},
                {headerName: 'Area Code', field: 'areacode'},
                {headerName: 'Phone Number', field: 'phonenumber'}
            ]


var persons2 ='<%= persons%>';


var persons3 = JSON.stringify(eval("(" + persons2 + ")"));

var persons4 = JSON.parse(persons3);

var rowData = persons4;


var gridOptions = {
    columnDefs: columnDefs,
    rowData: rowData,
    rowSelection: 'multiple',
        enableColResize: true,
        enableSorting: true,
        enableFilter: true,
        enableRangeSelection: true,
        suppressRowClickSelection: true,
        animateRows: true,

        debug: true,
    onGridReady: function (params) {
        params.api.sizeColumnsToFit();
    }
};
 addQuickFilterListener();
 function addQuickFilterListener() {
        var eInput = document.querySelector('#quickFilterInput');
        eInput.addEventListener("input", function () {
            var text = eInput.value;
            gridOptions.api.setQuickFilter(text);
        });
    }

// wait for the document to be loaded, otherwise
// ag-Grid will not find the div in the document.
document.addEventListener("DOMContentLoaded", function() {

    // lookup the container we want the Grid to use
    var eGridDiv = document.querySelector('#myGrid');

    // create the grid passing in the div to use together with the columns & data we want to use
    new agGrid.Grid(eGridDiv, gridOptions);
});

    </script>
</body>


</html>