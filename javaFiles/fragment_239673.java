function buildForm(form) {
    var files, formData, i, j, xhr;

    files = document.getElementById('attachFiles').files;
    formData = new FormData();

    formData.append('submittedFormAction', "attachDocumentSave");
    for (i = 0, j = files.length; i < j; i++) {
        formData.append('files', files[i]);
    }
    formData.append('testString', "foobar");

    xhr = new XMLHttpRequest();
    xhr.open('POST', form.action, true);
    xhr.send(formData);

    return false;
}