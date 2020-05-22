$.getJSON("/svrBooking/json/getEmployeesByManager",{
            manager: "Paul Walker",
            endDate: endDate.toISOString(), --> "2015-06-26T08:38:26.175Z"
            startDate: startDate.toISOString(), --> "2015-06-26T08:38:45.304Z"
            ajax: 'true'
            }, function (result) {...});