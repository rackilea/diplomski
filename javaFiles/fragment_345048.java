function dropUpload(event) {
    event.stopPropagation();
    event.preventDefault();

    var formData = new FormData();
    formData.append("file", event.dataTransfer.files[0]);

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "uploadServlet");
    xhr.send(formData);
}