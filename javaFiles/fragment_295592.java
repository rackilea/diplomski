functions.generateWord = function () {
    $http.post('/api/v1/surveys/genword', data.currentSurvey, {responseType: 'arraybuffer'})
        .success(function (response) {
            var blob = new Blob([response], {type: 'application/vnd.openxmlformats-officedocument.wordprocessingml.document'});
            var url = (window.URL || window.webkitURL).createObjectURL(blob);
            var element = angular.element('<a/>');
            element.attr({
                href: url,
                target: '_blank',
                download: 'survey.docx'
            })[0].click();
        });
};