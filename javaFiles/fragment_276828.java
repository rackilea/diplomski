.controller('YourController', function($http) {
  var controller = this;
  this.saveCriteria = function(criteria) {
    $http({method: 'POST', url: '/backend_url_handle_criteria', data: criteria})
    .success(function(data) {
        //do something with data
    }
  };
  this.saveTerm = function(term) {
    $http({method: 'POST', url: '/backend_url_handle_term', data: term})
    .success(function(data) {
        //do something with data
    }
  };
      this.send = function(formdata){
          this.saveCriteria(formdata.criteria);
          this.saveTerm(formdata.term);
      };
});