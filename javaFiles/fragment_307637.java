$('#categories').on('change', function() {
   $.ajax({
            url: '/tallies',
            type: 'GET',
            data: {
                category: $(this).val();
            },
            success: function(tallies) {
                // First, let's crear our tbody.
                $('#tallies').empty();

                // Now, let's go through each one of the tallies.
                $(tallies).each( function() {
                    // Here you should add your missing fields. I am just adding one as an example.
                    $('#tallies').append('<tr><td><span>' + this.nominee + '</span></td></tr>');
                })
            }
})