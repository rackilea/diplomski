function getJavaVersion() {
    var j, matches;
    for (j = 0;j < navigator.plugins.length;j += 1) {
        matches = navigator.plugins[j].description.match(/Java [^\d]+(\d+\.?\d*\.?\d*_?\d*)/i);
        if (matches !== null) {
            return matches[1];
        }
    }
    return null;
};

console.log(getJavaVersion()); // => 1.6.0_16