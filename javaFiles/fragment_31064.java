downloadFile: function ( record ) {
    var me = this;
    Ext.Ajax.request({
        url: record.get("url"),
        method: 'GET',
        success: function ( response ) {
            me.onFileDownloaded( response, record );
        },
        failure: function ( response ) {
        },
        scope: this,
        responseType: "arraybuffer",
        timeout: 300000
    });