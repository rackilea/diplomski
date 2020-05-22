// ... other code ...
actions.getSpreadsheet(ids)
    .then(result => {
        var date = new Date();
        var filename = "JSC " +
            date.getFullYear() +
            "." +
            (date.getMonth() + 1);

        var url = window.URL.createObjectURL(new Blob([this.s2ab(atob(result.data))], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;' }));
        var a = document.createElement('a');
        a.href = url;
        a.download = filename + '.xlsx';
        document.body.appendChild(a);
        a.click();
        a.remove();
    }).catch(error => {
        alert('Error retrieving report: ' + error);
    })

s2ab = s => {
    var buf = new ArrayBuffer(s.length);
    var view = new Unit8Array(buf);
    for (var i = 0; i != s.length; i++) {
        view[i] = s.charCodeAt(i) & 0xFF;
    }
    return buf;
}