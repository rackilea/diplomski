<a:outputPanel id="message-panel"
            onclick="hideMessages({delay:0.5,duration:0.9});">
                <h:messages id="messages" globalOnly="true" styleClass="message"
                    errorClass="errormsg" infoClass="infomsg" warnClass="warnmsg"
                    rendered="#{showGlobalMessages != 'false'}" />
            </a:outputPanel>
                <rich:effect name="hideMessages" for="message-panel" type="Fade" />

...

            <h:form>
                <a:commandLink action="#{myAction.runTest()}" value="Run Test"
                    reRender="message-panel" />
            </h:form>