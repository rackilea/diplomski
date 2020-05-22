pac4j.security.rules = [
  # Admin pages need a special authorizer and do not support login via Twitter.
  {"/admin/.*" = {
    authorizers = "admin"
    clients = "FormClient"
  }}
  # Rules for the REST services. These don't specify a client and will return 401
  # when not authenticated.
  {"/restservices/.*" = {
    authorizers = "_authenticated_"
  }}
  # The login page needs to be publicly accessible.
  {"/login.html" = {
    authorizers = "_anonymous_"
  }}
  # 'Catch all' rule to make sure the whole application stays secure.
  {".*" = {
    authorizers = "_authenticated_"
    clients = "FormClient,TwitterClient"
  }}
]