function uploadPicture() {
        var input = document.querySelector('input[type="file"]')
        console.log(productID);
        var data = new FormData()
        data.append('file', input.files[0])
        fetch('/uploadFile/', {
            method: 'POST',
            body: data
        })
        .then(response => Promise.all([response.status, response.json()]))
        .then(function([status, myJson]) {
            if (status == 200) {
                console.log("succeed!");
            } else {
                console.log("failed!");
            }
        })
        .catch(error => console.log(error.message));
    }