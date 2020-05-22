(function () {
    var a = [];
    document.querySelectorAll("td.i a").forEach(function (anchor) { a.push(anchor.textContent.trim());});

    console.log(a.join("\n"));
})();