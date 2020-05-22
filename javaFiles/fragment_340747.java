inlineNavOptions: { add: true, edit: true },
inlineEditing: {
    url: function (id, editOrAdd) {
        return "/RestWithDatabaseConnection/rest/" +
            (editOrAdd === "edit" ? "update" : "create");
    },
    mtype: function (editOrAdd) {
        return editOrAdd === "edit" ? "PUT" : "POST";
    },
    keys: true,
    serializeSaveData: function (postData) {
        return JSON.stringify(dataToSend);
    },
    aftersavefunc: function () {
        $(this).trigger("reloadGrid", [{current: true, fromServer: true}]);
    },
    addParams: {
        addRowParams: {
            position: "last",
            serializeSaveData: function (postData) {
                var dataToSend = $.extend({}, postData);
                // don't send any id in case of creating new row
                // or to send `0`:
                delete dataToSend.id; // or dataToSend.id = 0; 
                return JSON.stringify(dataToSend);
            }
        }
    }
}