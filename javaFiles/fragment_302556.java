let file = request.files['file'];
    let formData = new FormData();
    formData.append("file", Buffer.from(file.data), {
        filename: file.name,
        contentType: file.mimetype,
    });

    fetch(serviceCallRequestData.url, {
        method: serviceCallRequestData.requestObject.method,
        headers: serviceCallRequestData.requestObject.headers,
        body: formData
    }).then(response => {
        if (response.status !== 200) {}
    });