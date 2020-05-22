function busyProcess(form) {
    setTimeout(function() {
        for (var i = 0; i < form.elements.length; i++) {
            form.elements[i].disabled = true;
        }
    }, 50);

    // Remnant of your code here.
}