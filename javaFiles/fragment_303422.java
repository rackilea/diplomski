if (document.getElementById('checboxid').checked) {
    document.getElementById("buttonid").onclick = function() { 
        window.location.href = 'http://something.com'; 
    };
} else {
   alert("not checked");
}