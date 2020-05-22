el = document.getElementsByTagName('a');
[].forEach.call(el, function(ele, index, arr) {
    ele.onclick = function() {
        document.getElementById('changeme').innerHTML = ele.innerHTML;   
    }
});