function openPDF(source, name) {
    var screenHeight = screen.height;
    var height = screenHeight - 100;
    var width = height / (1.3);

    var specs = 'directories=0, location=0, toolbar=0, menubar=0, resizable=1, status=0';
    specs += ', height=' + height;
    specs += ', width=' + width;
    specs += ', left=' + (screen.width - width)/2;
    specs += ', top=' + 10;

    window.open(source, name, specs);
    return false;
}