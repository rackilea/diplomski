function replaceDomain(href) {
    var originalDomain = document.domain;
    var newDomain = "mysite.com/view/content?url=http://" + originalDomain;
    if (href.indexOf(originalDomain) == -1) href = "http://" + originalDomain + href;
    return href.replace(originalDomain, newDomain);
}
$(function () {
    //convert links
    $('a').each(function () {
        $(this).attr("href", replaceDomain($(this).attr("href")));
    });

    //convert imgs
    $('img').each(function () {
        $(this).attr("src", replaceDomain($(this).attr("src")));
    });

    //convert css links
    $('link').each(function () {
        $(this).attr("href", replaceDomain($(this).attr("href")));
    });
});