function sortOptions() {
    var options = document.getElementById('myselect').options;
    var optionsArray = [];
    for (var i = 0; i < options.length; i++) {
        optionsArray.push(options[i]);
    }
    optionsArray = optionsArray.sort(function (a, b) {           
        return a.innerHTML.toLowerCase().charCodeAt(0) - b.innerHTML.toLowerCase().charCodeAt(0);    
    });

    for (var i = 0; i <= options.length; i++) {            
        options[i] = optionsArray[i];
    }
    options[0].selected = true;
}

sortOptions();