fetch("https://randomuser.me/api/?gender=female&results=1")
            .then(Response::json)
            .then(data -> {
                console.log(Global.JSON.stringify(data));
                return null;
            }).
            catch_(error -> {
                console.log(error);
                return null;
            });