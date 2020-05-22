function login() {
            openFB.login(
                    function (response) {
                        if (response.status === 'connected') {
                            getInfo();
                            document.getElementById("token").value = response.authResponse.token;

                        } else {
                            alert('Facebook login failed: ' + response.error);
                        }
                    }, {scope: 'email'});
        }


        function getInfo() {
            openFB.api({
                path: '/me',
                success: function (data) {
                    console.log(JSON.stringify(data));
                    document.getElementById("userId").value = data.id;
                    document.getElementById("userEmail").value = data.email;
                    document.getElementById("userName").value = data.first_name;
                    document.getElementById("userSurname").value = data.last_name;
                    document.getElementById("facebookSubmit").click();
                },
                error: errorHandler});
        }