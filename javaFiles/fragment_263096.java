obsJwt.subscribe(myToken=>{
  localStorage.setItem("token", myToken.token);
  localStorage.setItem("type", myToken.type);
}, err=>{
  alert("error: " + err.message);
})