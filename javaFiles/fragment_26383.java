$(document).ready(function () {
     $('#myDataTable').DataTable({ 
         'destroy' : true,
         'serverSide' : true,
         'sAjaxSource': '/ApplicationName/Data/Person',
         'sAjaxDataProp': 'data',
         'order': [ [ 0, 'asc' ] ],
         'columns': 
         [ 
            {  'data': 'name',
                'render': function(data, type, row, meta){ 
                    if(type === 'display'){ 
                        data = '<a href="javascript:openPersonDetail(&apos;'+ row.socialSecurity +'&apos;);">' + data + '</a>' 
                    }  
                    return data; 
                } 
            } ,
            { 'data': 'socialSecurity'} ,
            { 'data': 'birthdate'} ,
            { 'data': 'gender'} 
         ],
         'scrollY' : 300,
         'scrollCollapse' : true,
         'paging' : true,
         'autoWidth' : true,
         'ordering' : true,
         'searching' : false,
         'pageLength' : 20,
         'lengthChange' : false,
         'pagingType' : 'full_numbers',
         'dom' : '<"top"ip>rt<"bottom"fl><"clear">' 
     }); 
 });