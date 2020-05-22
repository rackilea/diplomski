Ext.application({
  name: 'Fiddle',

  launch: function() {

      var store = Ext.create('Ext.data.Store', {
          fields: ['name', 'size', 'file', 'status']
      });

      var postDocument = this.postDocument;

      Ext.widget('container', {

          renderTo: Ext.getBody(),

          items: [{
              multiSelect: true,
              xtype: 'grid',
              id: 'UploadGrid',
              columns: [{
                  header: 'Name',
                  dataIndex: 'name',
                  flex: 2
              }, {
                  header: 'Size',
                  dataIndex: 'size',
                  flex: 1,
                  renderer: Ext.util.Format.fileSize
              }, {
                  header: 'Status',
                  dataIndex: 'status',
                  flex: 1,
                  renderer: this.rendererStatus
              }],

              viewConfig: {
                  emptyText: 'Drop Files Here',
                  deferEmptyText: false
              },
              store: store,

              listeners: {

                  drop: {
                      element: 'el',
                      fn: 'drop'
                  },

                  dragstart: {
                      element: 'el',
                      fn: 'addDropZone'
                  },

                  dragenter: {
                      element: 'el',
                      fn: 'addDropZone'
                  },

                  dragover: {
                      element: 'el',
                      fn: 'addDropZone'
                  },

                  dragleave: {
                      element: 'el',
                      fn: 'removeDropZone'
                  },

                  dragexit: {
                      element: 'el',
                      fn: 'removeDropZone'
                  },

              },

              noop: function(e) {
                  e.stopEvent();
              },

              addDropZone: function(e) {
                  if (!e.browserEvent.dataTransfer || Ext.Array.from(e.browserEvent.dataTransfer.types).indexOf('Files') === -1) {
                      return;
                  }

                  e.stopEvent();

                  this.addCls('drag-over');
              },

              removeDropZone: function(e) {
                  var el = e.getTarget(),
                      thisEl = this.getEl();

                  e.stopEvent();


                  if (el === thisEl.dom) {
                      this.removeCls('drag-over');
                      return;
                  }

                  while (el !== thisEl.dom && el && el.parentNode) {
                      el = el.parentNode;
                  }

                  if (el !== thisEl.dom) {
                      this.removeCls('drag-over');
                  }

              },

              drop: function(e) {
                  e.stopEvent();
                  Ext.Array.forEach(Ext.Array.from(e.browserEvent.dataTransfer.files), function(file) {
                      store.add({
                          file: file,
                          name: file.name,
                          size: file.size,
                          status: 'Ready'

                      });
                  });
                  this.removeCls('drag-over');
              },

              tbar: [{
                  text: "Upload",
                  handler: function() {
                      for (var i = 0; i < store.data.items.length; i++) {
                          if (!(store.getData().getAt(i).data.status === "Uploaded")) {
                              store.getData().getAt(i).data.status = "Uploading";
                              store.getData().getAt(i).commit();
                              //replace "insert your upload url here" with the real url
                              postDocument("insert your upload url here", store, i);
                          }
                      }

                  }
              }, {
                  text: "Erase EVERYTHING",
                  handler: function() {
                      store.reload();
                  }
              }, {
                  text: "Erase uploaded files",
                  handler: function() {
                      for (var i = 0; i < store.data.items.length; i++) {
                          var record = store.getData().getAt(i);
                          if ((record.data.status === "Uploaded")) {
                              store.remove(record);
                              i--;
                          }
                      }
                  }
              }, {
                  text: "Erase selected files",
                  handler: function() {
                      store.remove(Ext.getCmp('UploadGrid').getSelection());
                  }
              }]


          }],

          padding: 20


      });

  },

  rendererStatus: function(value, metaData, record, rowIndex, colIndex, store) {
      var color = "grey";
      if (value === "Ready") {
          color = "blue";
      } else if (value === "Uploading") {
          color = "orange";
      } else if (value === "Uploaded") {
          color = "green";
      } else if (value === "Error") {
          color = "red";
      }
      metaData.tdStyle = 'color:' + color + ";";
      return value;
  },

  postDocument: function(url, store, i) {
      var xhr = new XMLHttpRequest();
      var fd = new FormData();
      fd.append("serverTimeDiff", 0);
      xhr.open("POST", url, true);
      fd.append('index', i);
      fd.append('file', store.getData().getAt(i).data.file);
      //xhr.setRequestHeader("Content-Type","multipart/form-data");
      xhr.setRequestHeader("serverTimeDiff", 0);
      xhr.onreadystatechange = function() {
          if (xhr.readyState == 4 && xhr.status == 200) {
              //handle the answer, in order to detect any server side error
              if (Ext.decode(xhr.responseText).success) {
                  store.getData().getAt(i).data.status = "Uploaded";
              } else {
                  store.getData().getAt(i).data.status = "Error";
              }
              store.getData().getAt(i).commit();
          } else if (xhr.readyState == 4 && xhr.status == 404) {
              store.getData().getAt(i).data.status = "Error";
              store.getData().getAt(i).commit();
          }
      };
      // Initiate a multipart/form-data upload
      xhr.send(fd);
  }
});