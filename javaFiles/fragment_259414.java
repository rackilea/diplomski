$(function() {
            var assigned = "";
            var available = "";

            $('#sortable1').sortable({
                connectWith: '#sortable2',
                dropOnEmpty: true,
                update: function(event, ui) {
                    assigned = $(this).sortable("toArray", { key: "id" });
                    }
            }).disableSelection();

            $('#sortable2').sortable({
                connectWith: '#sortable1',
                dropOnEmpty: true,
                update: function(event, ui) {
                    available = $(this).sortable("toArray", { key: "id" });
                    }
            }).disableSelection();

            $('#assign').click(function(){
                $.ajax({
                    type: "POST",
                    url: "/ServerMonitoring/employee_management/serv_assignment/2",
                    data: JSON.stringify({
                            assignedServers: assigned,
                            availableServers: available
                    }),
                    datatype: "json",
                    'scriptCharset': "utf-8",
                    'contentType': "application/json;charset=UTF-8",
                    success: function(data) {
                        //alert("Success");
                    },
                    error: function (e) {
                        //alert("Error: " + e);
                    }
                });
                return false;
            });
            //debugger
        });