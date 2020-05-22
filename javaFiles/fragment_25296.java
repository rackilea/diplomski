pac4j.security {
  rules = [
    {"/admin/.*" = {
      authorizers = "ADMIN"
      clients = "FormClient"
    }}
  ]
}