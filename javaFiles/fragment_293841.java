*** Settings ***
Variables         vars.py

*** Variables ***
@{list}           foo    bar    lorem    ipsum    dolor    sit    amet

*** Test Cases ***
Example
    : FOR    ${item}    IN    @{list}
    \    Log    ${item}

Example2
    Call Method    ${obj}    my_method
    Should Be True    ${obj.args} == ()
    Call Method    ${obj}    my_method    arg
    Should Be True    ${obj.args} == ('arg',)
    Call Method    ${obj}    my_method     a1     a2
    Should Be True    ${obj.args} == ('a1','a2')