$(document).ready(function () {
    var empNo = 9870;
    $("#btnSubmit").click(function () {
        $.ajax({
            url: "http://localhost:8181/Test1/rest/employee/" + empNo, // Pass empNo
            type: "DELETE", // Use DELETE
           // data: JSON.stringify(empNo), Commented these two.
           // dataType: "json",
        })
    });
});