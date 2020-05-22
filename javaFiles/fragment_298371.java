$.get("Employee", function(data) {
    $(data).find("employee").each(function(){
        var EmployeeName = $(this).find("emp_name").text();
        var EmployeeAddr = $(this).find("emp_addr").text();
    });
});