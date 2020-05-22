...args: [{
         key: "fred",
         ajaxOptions: function() {
                            return {
                                url: "/rest/My_Dashboard/1.0/users", 
                                contentType: "application/json",
                                dataType: "json",
                            };
                        }
                    }]