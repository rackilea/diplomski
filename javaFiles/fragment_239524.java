function ajax(url, data) {
    return new Promise((resolve, reject) => {
        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = () => {
            if(xhr.status >= 200 && xhr.staus < 400) {
                if(xhr.readyState === 4) {
                    resolve(xhr.responseText);
                }
            } else {
                reject();
            }
        }

        xhr.open(data ? 'post' : 'get', url, true);
        xhr.send(data);

    });
}

function ftn_button_clicked() {
    ajax('/PointGenerate.java').then((responseText) => {
        document.getElementById('txt1').innerHTML.value = responseText;
        plotrandom(responseText);
        window.alert('*Sign*, much better!');
    });
}