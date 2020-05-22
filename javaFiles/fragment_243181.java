$http({
            method: 'POST',
            url: '/test', 
            data: JSON.stringify(answers)
        }).success(function(result) {
            // RESULT IS NULL