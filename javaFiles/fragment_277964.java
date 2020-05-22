Ext.define('List.controller.Main', {
extend: 'Ext.app.Controller',
config: {
    refs: {
        myList: 'presidentlist', // 'presidentlist' is xtype of your list
      },
    control: {
        myList: {
            itemtap: 'onMyListItemTap'
        },
     }
},
onMyListItemTap: function(list, index, target, record, e, eOpts) {
  // some functionality here
  var myLat = record.data.lat;  // etc.
  var myLng = record.data.lng;  // etc.
}