$(document).ready(function () {

    $('#saveSubject').submit(function (e) {
        $.post('/university/subjectAdd', $(this).serialize(), function (subject) {
            $('#subjectsTableResponse').last().append(
                    '<tr>' +
                    '<td align=\"center\">' + subject.title + '</td>' +
                    '<td align=\"center\">' + '<a href=\"c:url value=\'/subject/update/{'+subject.id+'}\'/>Update</a>'+'</td>'+
                    '<td align=\"center\">' + '<a href=\"c:url value=\'/subject/delete/{'+subject.id+'}\'/>Delete</a>'+'</td>'+
                    '</tr>'
            );
        }, 'json');

        clearInputs();

        e.preventDefault();
    });
});