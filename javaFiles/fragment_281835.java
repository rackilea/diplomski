chrome.browserAction.onClicked.addListener(run);

function run()
{
    var cookieName, cookieValue, cookieURL;
    cookieName = "Tab";
    chrome.tabs.getSelected(null, function(tab)
    {
        cookieValue = tab.title;
        cookieURL = tab.url;
        createCookie(cookieName, cookieValue, cookieURL);
    });
}

function createCookie(cookieName, cookieValue, cookieURL)
{
    chrome.cookies.set({name: cookieName, value: cookieValue, domain: ".youtube.com", url: cookieURL});
}