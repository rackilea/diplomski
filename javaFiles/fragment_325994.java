<script>
      $(document).ready(function(){
         <% for (int y=0;y<wordslist.size();y++) 
          { %> 
         $('h1').highlight('<%= wordslist.get(y) %>');
        <%  } %>
     });
</script>