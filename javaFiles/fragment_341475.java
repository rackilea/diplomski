<% int z=1; %>
<form method="Post" action="servlet">
        <input type="text" name="username" />
        <input type="password" name="password" />
        <input type="hidden" name="product_no" value="<%=z%>" />
        <input type='submit' />
</form>