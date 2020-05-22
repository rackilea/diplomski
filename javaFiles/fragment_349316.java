$("#clickTest1").on('click', callModal1);
$("#clickTest2").on('click', callModal2);

function callModal1(){
  $(function() {
    $( "#content1" ).dialog(({
      buttons: [
        {
          text: "Cancel",
          click: function() {
            $( this ).dialog( "close" );
          }
        }
      ]
    }));
  });
}

function callModal2(){
  $(function() {
    $( "#content2" ).dialog(({
      buttons: [
        {
          text: "Cancel",
          click: function() {
            $( this ).dialog( "close" );
          }
        }
      ]
    }));
  });
}