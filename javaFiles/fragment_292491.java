document.getElementById('image').onload = function(){
  if(this.naturalWidth > this.naturalHeight){
    this.style.Width = document.getElementById('container').style.Width + " !important";
    this.style.Height = "auto !important"; 
  }
  else{
    this.style.Height = document.getElementById('container').style.Height + " !important";
    this.style.Width = "auto !important"; 
  }
}