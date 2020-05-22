$jScript("#DetailPopUpContainer").load('../admin/DetailPopUp?rand='+Math.random(), function() {
                 $jScript(this).dialog({ 
                       autoOpen: true,
                       //height:540,
                       width:680,
                       //loadUrl: 'http://xyz/admin/popup',
                       position: [250, 150],
                       modal: true,
                       cache: false 


                 });