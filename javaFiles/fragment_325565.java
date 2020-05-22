${contents}=    Get File    ${file path}
@{lines}=    Split to lines    ${contents}
${matched elements}=    Get Webelements    ${LABEL PORTAIL XPATH }
: FOR    ${element}    IN    @{matched elements}
\  ${text}=     Get Text    ${element}
\  ${present}=  Run Keyword And Return Status    Should Contain    ${lines} 
${text}
\    Run Keyword If  ${present}    Log    '${text} matched'