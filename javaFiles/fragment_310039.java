function customerNameAvail() {
    $.ajax({
      url: 'userNameAvail',
      data: ({email : $('#email').val()}),
      success: function(data) {
          if(isError(data))
          {

    if(data=="email already registered"){
     alert('customer Name already exist');
      }
          else{

             alert('customer Name Available');
              }
          }
          else
          {
        alert(data.error);
          }
      }
    });
}