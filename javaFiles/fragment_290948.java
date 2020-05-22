fetch('http://localhost:3002/login', {
  method: "POST",
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json"
  },
  body: JSON.stringify({
    username: "foo",
    password: "bar"
  })
});