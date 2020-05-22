function checkExamNotification() {
    var url = contextPath + '/api/notification/checkExamNotification?accountId=' + accountId + '&sessionId=' + sessionId;
    var source = new EventSource(url);
    source.onmessage = function (event) {
        displayNumberOfNotification();
    };
}