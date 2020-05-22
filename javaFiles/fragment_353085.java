// create an observer instance
var observer = new MutationObserver(function(mutations) {
    mutations.forEach(function(mutation) {
        alert(mutation.type);
    });    
});

// configuration of the observer:
var config = {
    childList: true
};

// pass in the target node, as well as the observer options
observer.observe(elem, config);