fetch(
  "http://localhost:8080/oauth/token",
  {
    method: "POST",
    headers: {
      "Content-Type": "application/x-www-form-encoded"
    },
    body: “grant_type=password&clientId=my-trusted-client&username=user&password=user123&scope=user_info“
  }
)