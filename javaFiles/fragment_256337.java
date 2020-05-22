<script>
    $('#tab').DataTable( {

        processing: true,
        serverSide: true,
        ajax: {
            url: '/pgTabelka',
        },
        columns: [
            {data: "id"},
            {data:"name"},
            {data:"file"},
            {data:"cassid"},
            {data:"categoryid"},
            {data:"datefrom"},
            {data:"frequency"},
            {data:"markers"},
            {data:"unit"},
            {data:"feed"},
            {data:"userid"},
            {data:"createdate"},
            {data:"changedate"}
        ]
    } );

    </script>