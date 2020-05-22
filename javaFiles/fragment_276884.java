const regex = /qwq=\d*\;?/g;
var items = ["+17005554141;qwq=123454",
            "+17005554141",
            "+17005554141;qwq=1234;ddd=ewew;otg=383"];

for(let i = 0; i < items.length; i++) {
  console.log("Item before replace: " + items[i]);
  console.log("Item after replace: " + items[i].replace(regex, "") + "\n\n");
}