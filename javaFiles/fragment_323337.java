<head>
    <script>
        $(function(){
            $("#event, #company").on('change',function(){
                $("#myForm").submit();
            });
        });
    </script>
</head>
<body>
    <form id="myForm">
        <div>
        ...
            <s:select id="event"   name="event"   list="events"    />   
        ...
            <s:select id="company" name="company" list="companies" />   
        ...
        </div>
    </form>

    <div> 
        ...
        Table - iterate **dataForBillsJspList** here    
        ...
    </div>

</body>