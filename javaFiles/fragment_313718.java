<div ng-app="myApp" ng-controller="myCtrl">
    <div ng-repeat="result in results" ng-if="$index % 2 == 0" class="row">
        <div class="col-xs-6">First: {{results[$index].birthDate}}</div>
        <div class="col-xs-6">Second: {{results[$index + 1].birthDate}}</div>
        <br/>
    </div>
</div>