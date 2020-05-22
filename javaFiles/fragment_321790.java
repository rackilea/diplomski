<form action="${pageContext.request.contextPath}/index" method="POST"  enctype="multipart/form-data" name="uploadForm"> 
    <label for="file">Choose a file:</label>
    <input type="file" name="file" width="150"/>
    <input type="submit" value="Submit" name="submit"/>
    <input type="submit" value="Tokenization" name="button1" />
    <input type="submit" value="Split" name="button2" />
    <input type="submit" value="pos" name="button3" />
</form>