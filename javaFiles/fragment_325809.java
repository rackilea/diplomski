tableTwo = $('#table2').dataTable({
            ajax: "/staff/getStaffInfoForArea?"+areaCode,
            columns: [
                //your columns
            ]
        });