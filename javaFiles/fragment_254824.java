$.ajax({
url: "sessions/" + javaRest.cookie.get("sessionId") + "/",
type: "DELETE",             
success : //do something,
error : //do something;
)}