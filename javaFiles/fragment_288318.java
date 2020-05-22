'use strict';

var frontendApp = angular.module('frontendApp', ['ngRoute'])
    .config([ '$routeProvider', function ($routeProvider){
    $routeProvider
    .when('/rest',{
        templateUrl: 'resources/angular-app/registration/registration.html',
        controller: 'RegistrationCtrl'
    });
}]);