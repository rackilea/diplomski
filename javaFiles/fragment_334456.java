function parse(paths) {
  var resultObj = {};
  paths.forEach(function(path) {
    var nodes = path.split("/");
    recurse(nodes, resultObj);
  });
  console.log(resultObj);
  console.log(JSON.stringify(resultObj));
}

function recurse(path, obj) {
  if (!path.length)
    return obj;
  var node = path.shift();
  if (!obj.hasOwnProperty(node))
    obj[node] = path.length ? {} : "";
  return recurse(path, obj[node]);
}

var arr = ["a/b/c1", "x/b", "a/b/c/d", "m"];
parse(arr);