$(document).ready(function() {
// Setup - add a text input to each footer cell
$('#example thead th').each( function () {
    var title = $(this).text();
    $(this).append( '<input type="text" placeholder="Search '+title+'" />' );
} );

// DataTable
var table = $('#example').DataTable();

// Apply the search
table.columns().every( function () {
    var that = this;

    $( 'input', this.header() ).on( 'click', function(e) {
        e.stopPropagation();
    } );

    $( 'input', this.header() ).on( 'keyup change', function () {
        if ( that.search() !== this.value ) {
            that
                .search( this.value )
                .draw();
        }
    } );
} );