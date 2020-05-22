function captureEnter() {
 if (window.event.keyCode == 13) {
    document.getElementById("txtArea").value =document.getElementById("txtArea").value + "<br/>";
    return false;
}
else {
    return true;
}
}