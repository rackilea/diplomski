let numTiles = 8;
for (let i = 0; i < numTiles; i++) {
  let row = "";
  for (let j = 0; j < numTiles; j++) {
    if (i == 0 || i == numTiles - 1) {
      row += "1";
    } else if (i + j == numTiles - 1) {
      row += "2";
    } else {
      row += " ";
    }
  }
  console.log(row + '\n');
}