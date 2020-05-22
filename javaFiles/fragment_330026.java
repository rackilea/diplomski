let app = angular.module('app', []);
app.controller('ctrl', ['$scope', ($scope) => {

    $scope.numberOfRows = 0;
    $scope.data = [];

    $scope.$watch('data', () => {
        console.log($scope.data);
    }, true);

}]);
app.filter('range', function () {
    return function (input, total) {
        total = parseInt(total, 10);

        for (let i = 0; i < total; i++) {
            input.push(i);
        }
        return input;
    };
});


<div ng-app="app">
<div ng-controller="ctrl">
    <input type="number" ng-model="numberOfRows" />
    <br />
    <table width="100%">
    <tr>
        <th>nummin</th><th>nummax</th><th>...</th>
    </tr>
    <tr ng-repeat="i in [] | range:numberOfRows">
        <td>
        <input type="number" ng-model="data[i].nummin" />
        </td>
        <td>
        <input type="number" ng-model="data[i].nummax" />
        </td>
        <td>...</td>
    </tr>
    </table>
</div>
</div>