$.ajax(
{
  url:'showcart.jsp,'//Or whatever name is 
  type:'get',
  success:function(response)
  {
     $('.testtmpblock').html(response);
  }
});