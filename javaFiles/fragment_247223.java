$routeProvider
  .when('/', {
    controller: 'SimpleController',
    templateUrl: 'view1.jsp'
  })
  .when('/second', {
    controller: 'FirstController',
    templateUrl: 'view2.jsp'
  })
  .otherwise({
    redirectTo: '/'
  });