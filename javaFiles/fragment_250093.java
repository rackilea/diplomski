columns: 
          [
               {
                header : 'ID',  dataIndex: 'Id', flex:0.5 ,filterable: true,
                editor: 
                {
                    xtype: 'textfield',
                    allowBlank: false
                },
                filter: 
                {
                    type: 'numeric'
                } 
              },
              {
                header : 'First Name',  dataIndex: 'fname', flex:1 ,sortable : false,filterable: true,
                filter: 
                {
                    type: 'string'
                },
                editor: 
                {
                    xtype: 'textfield',
                    allowBlank: false
                }
             },
              {
                header : 'Last Name',  dataIndex: 'lname', flex:1,filterable: true,
                editor: 
                {
                    xtype: 'textfield',
                    allowBlank: false
                },
            filter: 
                {
                    type: 'string'
                }
              },
              {
                header : 'DOB',  dataIndex: 'date', flex:1,filterable: true, renderer: Ext.util.Format.dateRenderer('m/d/Y'),
                editor: 
                {
                    xtype: 'textfield',
                    allowBlank: false
                },
        filter: 
                {
                    type: 'date'
                }

            },
              {
                header : 'Gender',  dataIndex: 'genderId', flex:0.5,
                editor: 
                {
                    xtype: 'textfield',
                    allowBlank: false
                },
        filter: 
                {
                    type: 'string'
                }
              },
              {
                header : 'Age',  dataIndex: 'age', flex:0.5,filterable: true,
                editor: 
                {
                    xtype: 'textfield',
                    allowBlank: false
                },
        filter: 
                {
                    type: 'numeric'
                }
              },
              {
                header : 'Country',  dataIndex: 'country', flex:1,
                editor: 
                {
                    xtype: 'textfield',
                    allowBlank: false
                },
        filter: 
                {
                    type: 'numeric'
                }
              },
              {
                header : 'Email', dataIndex: 'email', flex:2,filterable: true,
                editor: 
                {
                    xtype: 'textfield',
                    allowBlank: false
                },
        filter: 
                {
                    type: 'string'
                }
              },
              {
                header : 'Phone', dataIndex: 'phone', flex:1,filterable: true,
                editor: 
                {
                    xtype: 'textfield',
                    allowBlank: false
                },
        filter: 
                {
                    type: 'numeric'
                }
              }
          ]
    });