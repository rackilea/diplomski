*** Variables ***
@{list}           foo    bar    lorem    ipsum    dolor    sit    amet

*** Test Cases ***
Example
    : FOR    ${item}    IN    @{list}
    \    Log    ${item}