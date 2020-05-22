saveBulkBoxComments : function(){


         grid = this.getPositionPanel();
         var store = grid.getStore();


         formObj = this.getBoxCommentsFormPanel().getForm();
         var fieldValues = formObj.getFieldValues();

         var value='';


         selectedRecords = grid.getSelectionModel().getSelection();


         Ext.each(selectedRecords, function(item) {
             value +=item.get('groupId') +',';
             }            
         );

         Ext.Ajax.request({
             url: SAVE_BULK_BOX_COMMENTS_URL,
             method: 'POST',
             params: {
                 groupIds :value,
                 positionDate: this.parentRecordData.data.positionDate,
                 boxStatus: fieldValues.boxStatus,
                 csrComment: fieldValues.csrComment

             },

             success: function(result, action, response) {
                 var jsonData = Ext.decode(result.responseText);


                 var jsonRecords = jsonData.records;

                 Ext.getCmp('boxCommentsWindow').close();
                 this.loadPositions();

                },

                scope: this 
                });
             }


});