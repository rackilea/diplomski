angular.module('publicStory').service('myStoryService', myStoryService);

function myStoryService($http){
    // Public functions
    this.getYourStoryById = getYourStoryById;

    // Implementation
    function getYourStoryById (yourStory) {
        return $http({
            method : 'POST',
            url : 'yourStory',
            data : angular.toJson(yourStory),
            headers : {
                'Content-Type': 'application/x-www-form-urlencoded'
            }
        }).then(function(response) {
            alert("Got response for getYourStoryById");
            console.log(response.data);
            return response.data;
        });
    }
}