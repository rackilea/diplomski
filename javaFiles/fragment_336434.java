function displayText(title, text) {
    var escapeHTML = function(s) { return (s+'').replace(/</g, '&lt;'); };
    var style = '*{width:100%;height:100%;box-sizing:border-box}';
    style += 'html,body{margin:0;padding:0;}';
    style += 'textarea{display:block;}';
    var html = '<!DOCTYPE html>';
    html += '<html><head><title>';
    html += escapeHTML(title);
    html += '</title>';
    html += '<style>' + style + '</style>';
    html += '</head><body><textarea>';
    html += escapeHTML(text);
    html += '</body></html>'

    var url = 'data:text/html,' + encodeURIComponent(html);
    chrome.windows.create({
        url: url,
        focused: true
    });
}