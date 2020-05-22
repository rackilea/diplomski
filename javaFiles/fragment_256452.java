$(document).ready(function() {
    var jVersion = "";
    for (var i = 0; i < deployJava.getJREs().length; ++i) {
        jVersion += deployJava.getJREs()[i];
    }

    var url = 'saveJavaVersionAction.jsp';
    var params = 'version=' + jVersion;

    $.ajax({
        url: url,
        data: params,
        success: function(html) {
            $("#results").append(html);     
        }
    });

});