obsJwt.subscribe(myToken=>{
  const obj = JSON.parse(myToken);
  localStorage.setItem("token", obj.token);
  localStorage.setItem("type", obj.type);
}, err=>{
  alert("error: " + err.message);
})