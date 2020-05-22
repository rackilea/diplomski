formDeleting: {
    mtype: "DELETE",
    url: function (rowid) {
        return "/RestWithDatabaseConnection/rest/delete/" + rowid;
    },
    ajaxDelOptions: { contentType: "application/json" },
    serializeDelData: function () {
        return "";
    }
}