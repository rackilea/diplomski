Ext.define('AM.store.M2MResources', {
    extend: 'Ext.data.DirectStore',
    requires: 'Ext.direct.*', //  use ext-direct for binding
    model: 'AM.model.M2MResource',

    autoLoad: true,
    buffered: true,
    pageSize: 20,
    purgePageCount: 0,
    leadingBufferZone: 60,
    trailingBufferZone: 0,

    constructor : function(config) {
        config = config || {};

        config.proxy = {
            type: 'direct',
            directFn : M2MResourceServlet.getM2Mresources,
            reader: {
                type: 'json',
                root: 'result'
            },
            paramOrder: 'start,limit',
            paramsAsHash: false
        };

        this.callParent([config]);
    },

    toString: function() {
        return 'M2MResources: count = ' + this.getCount() + ', totalCount = ' 
                + this.getTotalCount();
    }
});