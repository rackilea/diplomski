function f(A, S, B=new Array(A.length).fill(false), i=A.length - 1){
  if (A[i] == S){
    B[i] = true
    return B
  }
    
  if (i == 0){
    if (A[i] == S){
      B[i] = true
      return B
    }
    return false
  }
  
  if (A[i] <= S){
    let maybeB = f(A, S - A[i], B, i - 1)
    if (maybeB){
      B[i] = true
      return B
    }
  }

  return f(A, S, B, i - 1)
}

var A = [3, 34, 4, 12, 5, 2]
var S = 9

console.log(JSON.stringify(A))
console.log(`Target: ${S}`)
console.log(JSON.stringify(f(A, S)))

S = 199
console.log(`\nTarget: ${S}`)
console.log(JSON.stringify(f(A, S)))