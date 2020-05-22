<script>
function checkit(){
    var val = document.getElementById('txt').value;
    if(val == "good"){
        alert("success");
    }else{
        alert("failure!");
    }
}    
</script>
<form onsubmit='checkit()'>
    <input type='text' id="txt" />
    <input type='submit' value='Submit' />
</form>