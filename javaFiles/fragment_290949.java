fetch('http://localhost:3002/login?username=' + username 
                                 + '&password=' + password, {
  method: "POST",
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json"
  }
});