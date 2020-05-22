<aui:form id="smsSender" method="post" action="${sendSmsUrl}">    
    <aui:input type="text" name="phoneSuffix" maxlength="7" />
    <aui:input type="textarea" id="message" maxlength="70" name="message" />
    <br />
    <aui:button type="submit" value="Send" />
</form>