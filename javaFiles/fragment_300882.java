<form action="servletname" method="post">
    <input type="text" name="foo" value="${param.foo}" ${not empty messages.succes ? 'disabled' : ''}>
    <span class="error">${messages.foo}</span><br>
    <input type="text" name="bar" value="${param.bar}" ${not empty messages.succes ? 'disabled' : ''}>
    <span class="error">${messages.bar}</span><br>
    <input type="submit">
    <span class="succes">${messages.succes}</span><br>
</form>