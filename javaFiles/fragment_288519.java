# Identifies SessiondIDs without HTTPOnly flag and sets the "http_cookie" ENV
# Token for Apache to read
SecRule RESPONSE_HEADERS:/Set-Cookie2?/ "!(?i:\;? ?httponly;?)" "chain,phase:3,t:none,pass,nolog"
  SecRule MATCHED_VAR "(?i:(j?sessionid|(php)?sessid|(asp|jserv|jw)?session[-_]?(id)?|cf(id|token)|sid))" "t:none,setenv:http_cookie=%{matched_var}"

# Now we use the Apache Header directive to set the new data

Header set Set-Cookie "%{http_cookie}e; HTTPOnly" env=http_cookie