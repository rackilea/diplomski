global
    debug
    lua-load handle_redirect.lua

frontend web1
    bind *:8080
    mode http

    default_backend app1

backend app1
    mode http

    http-response lua.handle_redirect if { status eq 301 }

    server s1 127.0.0.1:9000