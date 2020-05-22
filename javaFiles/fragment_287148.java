$scope.$watch('number1', function (newVal, oldVal) {
    if (newVal !== oldVal) {
        // Call total1 function
         total1();
    }
});