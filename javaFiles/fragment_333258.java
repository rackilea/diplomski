<script>
    $(document).ready(function() {
       var table =  $('#LogTable').DataTable({
            "bSort" : true,
            "bProcessing" : false,
            "bInfo" : true,
            bServerSide : true,
            sAjaxSource : "./Log!List.action",
            sServerMethod : "POST",
            "aoColumns" : [ 
                {"data" : "LogId"}, 
                {"data" : "tableName"}, 
                {"data" : "columnName"}, 
                {"data" : "oldValue"}, 
                {"data" : "newValue"}, 
                {"data" : "changeTypeText"}, 
                {"data" : "changedByName"}, 
                {"data" : "changedOn"}, ],
        });
        // Apply the search
        table.columns().every( function () {
            var that = this;
            $('input', this.footer() ).on( 'keyup change', function () {
                that
                    .search( this.value )
                    .draw();
            } );
            $( 'select', this.footer() ).on( 'keyup change', function () {
                that
                    .search( this.value )
                    .draw();
            } );
        } );
    });
</script>