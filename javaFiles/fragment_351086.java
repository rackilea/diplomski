<div id= "status" style="display:none;">
    <form action="/status" method="POST">
        <input type="submit" name="showstatus" id="txtSubmit" value="Status" />
    </form>
</div>
<div id="result">
    <pre>
        ${requestScope.utilOutput}
    </pre>
</div>