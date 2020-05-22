jQuery.each(response, function(index, item) {
    //now you can access properties using dot notation
    alert(item.id);
    alert(item.name);
    alert(item.obj.id);
    alert(item.obj.owner.school.phone);
});