$(document).ready(function(){
  $('#uploadForm').submit(function() {
     //Show some throbber and ensure ClickSuperUtil.submitForm() returns true
     return ClickSuperUtil.submitForm();
  });
});

<h:form id="uploadForm" preprendId="false" enctype="multipart/form-data">