app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push(function ($q) {
        return {
            'request': function (config) {
                var readCookie = function (k, r) {
                    return (r = RegExp('(^|; )' + encodeURIComponent(k) + '=([^;]*)').exec(document.cookie)) ? r[2] : null; //CafePasta from https://stackoverflow.com/a/5639455/2557818
                };
                if (config.url.indexOf("/app1") > 0) {
                    config.headers['APP-1-X-XSRF-TOKEN'] = readCookie("APP-1-XSRF-TOKEN", document.cookie);
                } else if (config.url.indexOf("/app2") > 0) {
                    config.headers['APP-2-X-XSRF-TOKEN'] = readCookie("APP-2-XSRF-TOKEN", document.cookie);
                } else if (config.url.indexOf("/app3") > 0) {
                    config.headers['APP-3-X-XSRF-TOKEN'] = readCookie("APP-3-XSRF-TOKEN", document.cookie);
                }
                return config || $q.when(config);
            }
        };
    });
}]);