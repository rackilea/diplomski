function remainder(dividend, divisor, precision = 4) {
  var result = (dividend / divisor).toString();
  var dot = result.indexOf('.');
  if(dot == -1) return 0; // it was a perfect division (9 / 3 for example)
  
  var remainder = "0." + result.substr(dot + precision);  // get the part after the precision
  return Math.round(remainder * divisor);                 // multiply it by the divisor and round the result
}

console.log(remainder(9.1, 3, 3));