<script>
  $(document).ready(function(){
     $.ajax({
      url: "/YOUR_DOMAIN/SERVLET",
      type: "POST",
      data : {json: "hello" }, //in servlet use request.getParameters("json")
      dataType : 'json',
      success: function(data) {}, //data holds {success:true} - see below
      error: errorFunction
     }); 
  })
</script>