<div id="login">
#{form @login(), id:'formLogin'}
<p class="field">
    <label>User Code:</label>
    <input type="text"  name="userCode" size="19" value="${flash.userCode}" required>
 </p>

<p class="field">
    <label>Password:</label>
    &nbsp;<input type="password" name="password" size="19" required>
</p>
<p class="buttons">
    <input type="submit" value="Login">
</p>
#{/form}