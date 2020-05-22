table {
  border-collapse: collapse;  
  width: 100%
}
td {
  height: 100px;
  border: 1px #ccc solid;
}
input {
  border: 1px #ccc solid;
  height: 100%;
  width: 100%;  
  box-sizing: border-box;          /* works fine with IE8+ */
  -moz-box-sizing: border-box;     /* works fine Firefox */
/*-webkit-box-sizing: border-box;     height is not correct in Chrome
 *-webkit-box-sizing: content-box;    width is not correct in Chrome  */  
}
div.input-container {
  height: 100%;
  width: 100%;  
  -webkit-box-sizing: border-box;
}