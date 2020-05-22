Ext.data.JsonP.request({
        url: "http://10.1.50.66:7001/Simulador/webresources/hello",
        callbackKey: 'callback1',
        params: {
        },
        success : function(response) {
            console.log("Spiffing, everything worked");
            // success property
            console.log(response.success);
            // result property
            console.log(response.result);
            console.log(response.msj);
         },
         failure: function(response) {
              console.log(response);
              Ext.Msg.alert('Error', 'Please try again.', Ext.emptyFn);
          }
    });