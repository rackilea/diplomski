$(document).ready(function () {

       function getAllSchoolClasses(){
          var schoolClasses = [];
                    $.ajax({
                        type: "GET",
                        url: cr + "/task/getAllSchoolClasses.action",
                        dataType: "json",
                        success: function (data) {
                            for(var i=0; i<data.length; i++)
                                schoolClasses[i] = {classID:data[i].id, className:data[i].name};
                            //schoolClasses[i] = {classID:data[i].id, className:data[i].name};
                        },
                        async:false
                    });
                    return schoolClasses;
                }

    var maxScoreModel = function (id, score, schoolclass) {
        var self = this;

        self.schoolClasses = getAllSchoolClasses();
        self.scores = [
            { val: 1 },
            { val: 2 },
            { val: 3 },
            { val: 4 },
            { val: 5 }
        ];
        self.id = ko.observable(id);
        self.selectedMaxScore = ko.observable(score);
        self.selectedSchoolClass = ko.observable(schoolclass);
    };        


         var taskViewModel = function() {
                var self = this;


         self.maxScores = ko.observableArray([
            new maxScoreModel(),
            new maxScoreModel()
        ]);

        self.addMaxScore = function(id,score, schoolclass) {
            self.maxScores.push(new maxScoreModel(id,score, schoolclass));
        };
        self.removeMaxScore = function(maxScore) { self.maxScores.remove(maxScore) };


        };


            ko.applyBindings(new taskViewModel());
    });