window.app.config([
    '$routeProvider',
    '$controllerProvider',
    '$compileProvider',
    '$filterProvider',
    '$provide',
    function ($routeProvider, $controllerProvider, $compileProvider, $filterProvider, $provide) {

        $routeProvider.when('/login', {
            templateUrl: 'components/login/partials/login.html',
            resolve: {
                load: ['$q', '$rootScope', function ($q, $rootScope) {

                    var deferred = $q.defer();

                    // lazy load controllers, etc.
                    require ([
                        'components/login/controllers/loginController',
                        'components/login/services/loginService'
                    ], function () {

                        $rootScope.$apply(function () {
                            deferred.resolve();
                        });

                    });

                    return deferred.promise;
                }]
            }
        });


        //store a reference to various provider functions
        window.app.components = {
            controller: $controllerProvider.register,
            service: $provide.service
        };

    }
]);