setInterval(function() {
    // Anything in here will be executed every 180 seconds (180 000 milliseconds)
    createDiv();
},180000);

// This function will add an empty div to your news element every 180 seconds
function createDiv() {
    var createdDiv = document.createElement("div");
    createdDiv.innerHTML = "TEST";
    document.getElementById("news").appendChild(createdDiv);
}