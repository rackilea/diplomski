$(document).ready(function () {
    $.getJSON('SearchServlet', function(tweet) {
        var table = $('#resultsTable');
        $('<tr>').appendTo(table)
                 .append($('<td>').text(tweet.username))
                 .append($('<td>').text(tweet.status))
                 .append($('<td>').text(tweet.date))
                 .append($('<td>').text(tweet.retweets));
    });
});