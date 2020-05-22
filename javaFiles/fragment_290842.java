function stockWatchEnterSubmit(keyCode) {
    if (keyCode == 13) {
        document.getElementById('stockwatchSubmit').click();
        return false;
    } else {
        return true;
    }
}