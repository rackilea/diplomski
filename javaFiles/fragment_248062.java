function show(M){
  let str = '';
  for (let row of M)
    str += JSON.stringify(row) + '\n';
  console.log(str);
}

function f(M){
  console.log('Input:\n');
  show(M);
  
  let solution = new Array();
  for (let i=0; i<M.length; i++)
    solution.push(new Array(M[0].length).fill(Infinity));
    
  solution[0][0] = M[0][0];

  // only one choice along
  // the top horizontal and
  // left vertical
  
  for (let x=1; x<M[0].length; x++)
    solution[0][x] =
      M[0][x] + solution[0][x - 1];

  for (let y=1; y<M.length; y++)
    solution[y][0] =
      M[y][0] + solution[y - 1][0];
      
  console.log('Solution borders:\n');
  show(solution);

  // two choices otherwise:
  // the best of option 1 or 2

  for (let y=1; y<M.length; y++)
    for (let x=1; x<M[0].length; x++)
      solution[y][x] =
        M[y][x] + Math.min(
          solution[y][x - 1],
          solution[y - 1][x]
        );
        
  console.log('Full solution:\n');
  show(solution);
  
  return solution[M.length-1][M[0].length-1];
}

let arr = [];
arr[0] = [0, 7, -7];
arr[1] = [6, 7, -8];
arr[2] = [1, 2, 0];

console.log(f(arr));