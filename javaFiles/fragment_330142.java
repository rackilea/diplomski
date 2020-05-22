$.ajax({
  url:"downloadFIReport.do",
  type:"post",
  dataType:"json",
  data:{id:$("#id").val(),name:$("#name").val()},
  success:function(){}
});