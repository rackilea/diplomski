<script>
  window.onload = function(){        
    document.getElementById("country").value = '<% out.print(countrycd); %>';
    var e= document.getElementById("country");
    var str = e.options[e.selectedIndex].text;

    document.getElementById("countryName").innerHTML = str;  //This line changed
  };
</script>