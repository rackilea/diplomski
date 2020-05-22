<form id="deleteForm" method="POST" action="bookAuthorControls">
    <div id="authorTable">
         ...
         <td><input type="checkbox" name="boxes" id="boxes" class="boxes" value="${record.bookID}" /> </td>
         ...
    </div>

    <div id="deleteContainer">
        <button type="submit" id="deleteButton" name="deleteButton"       >Delete</button>
    </div>
</form>