self.allThings = function () {
        ThingService.things()
            .then(
                function (data) {
                    self.things = data;
                },
                function (errResponse) {
                    console.error("Error retrieving thing list");
                }
            );
    };