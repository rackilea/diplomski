$(document).ready(function () {
      if (${not empty refId}) {
          var refId = ('${refId}');
          document.getElementById('bank-card-form').action = 'https://bpm.shaparak.ir/pgwchannel/startpay.mellat?RefId=' + refId;
          document.getElementById('bank-card-form').submit();

    }
   });