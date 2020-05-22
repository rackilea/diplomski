$(document).ready(function() {
    $('#myForm').submit(function() {
        var param1 = $(this).find('#param1');
        var param2 = $(this).find('#param2');

        $.ajax({
          url: '/route/to/action',
          type: 'POST',
          data: {
            'param1': param1, /* setParam1(String param1) required!*/
            'param2': param2, /* setParam2(String param2) required!*/
          },
          dataType: 'json',
          complete: function (jqXHR, textStatus) {
              // DO SOMETHING
          },
          success: function (response) {
              // DO SOMETHING
          },
          error: function (jqXhr, textStatus, errorThrown) {
              console.log(jqXhr);
              console.log(textStatus);
              console.log(errorThrown);
              // DO SOMETHING
          }
        });
    });
});