function query(form) {
    //         ^^^^

    $.get('QueryHelper', $(form).serialize(), function (res) {
        //               ^^^^^^^^^^^^^^^^^^^

        // ...
    });
}