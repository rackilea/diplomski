$(document).ready(function() { 
    $('#multichecks').select2(); 
    $('#multichecks').multiselect({ 
    enableFiltering: true,
 enableCaseInsensitiveFiltering: true,
 filterPlaceholder: 'Search for something...',
    onChange: function test(){ 
    document.getElementById('textbox').value = $('#multichecks').val().join(',') 
    } 
    }); 
    });