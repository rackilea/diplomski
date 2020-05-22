$('#submitButton').on('click', function() {
            var expenseDetailsListVO = {};
            expenseDetailsListVO = getData();
            console.log(expenseDetailsListVO);
            var data = JSON.stringify(expenseDetailsListVO);
            console.log(data);
            $.ajax({
                url : "${pageContext.request.contextPath}/saveExpenses",
                data : data,
                method : 'POST',
                contentType : "application/json",
                success : function(data) {

                },
                error : function(data) {

                }
            });
        });