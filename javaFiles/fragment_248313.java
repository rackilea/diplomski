$.ajax({
                    type: "POST",
                    url: "/GPS-VTS/change_account_password.do",
                    async: false,
                    data: "oldpassword="+oldPassword+"&newpassword="+newPassword+"&confirmpassword="+confirmPassword,
                    dateType: "string",
                    success: function(response){
                     .....

           }