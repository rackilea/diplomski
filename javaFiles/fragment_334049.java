function addBook() {
    jQuery.ajax({
        url: "http://localhost:8080/book_service/rest/books",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify( {
            "bid"   :$("#sid").val(),
            "title" :$("#stitle").val(),
            "price" :$("#sprice").val()
        }),
});