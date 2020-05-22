App.config([
  '$stateProvider'
  '$urlRouterProvider'

  ($stateProvider, $urlRouterProvider) ->

    $urlRouterProvider.otherwise("/")

    $stateProvider
      .state('intro', {
        url: "/",
        templateUrl: '/templates/intro.html'
      })