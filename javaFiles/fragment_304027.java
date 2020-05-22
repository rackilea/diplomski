WhateverAuthorizeRequestsReturns partial = http
    .csrf().disable()
    .cors().disable()
    .authorizeRequests();

if (dev) // note: you don't need 'dev == true' like you had
{
    partial.someOptionalThing();
    // if the type is immutable then you need to reassign e.g.:
    // partial = partial.someOptionalThing()
}

partial.something()
    .somethingElse()
    .andTheRest();