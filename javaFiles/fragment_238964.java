$(document).ready(function () {
    $('#check').click(function () { 
        $('.reg')[this.checked ? "hide" : "show"]();                   
        $('#reg')[this.checked ? "hide" : "show"]();
    });
});