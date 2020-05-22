.factory('authHttpResponseInterceptor',['$q','$location','$injector',function($q,$location, $injector){
return {
    responseError: function(rejection) {

        if (rejection.status === 403) {
            console.error("Response 403 in interceptor");
            $injector.get('$state').go('unauthorised');
        }

        return $q.reject(rejection);
    }