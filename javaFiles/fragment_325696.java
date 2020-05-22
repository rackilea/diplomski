$('#categorias').on('change', function() {
    var value = $(this).val();
    if(value === "Dulce de Leche") {
        $('#id').val(1);
    }
    // Now you just fill the rest.
})