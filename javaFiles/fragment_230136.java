$('form').submit(function(e) {
  e.preventDefault();
  $.ajax({
    url: 'https://api.telegram.org/bot' + $('#token').val() + '/sendMessage',
    method: 'POST',
    data: {
      chat_id: $('#chat_id').val(),
      text: $('#text').val()
    },
    success: function() {
      alert('your message has been sent!');
    }
  });
});