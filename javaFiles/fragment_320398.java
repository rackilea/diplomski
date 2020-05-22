console.log(getHexColor(-16731137)); // light blue
console.log(getHexColor(-1218518)); // orange

function getHexColor(number){
    return "#"+((number)>>>0).toString(16).slice(-6);
}