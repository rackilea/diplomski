/* Create a new object from scratch to convert to JSON later */
obj = {          
    deviceType: $tds.eq(1).find("select")[0].val(),
    days: $tds.eq(2).find("select")[0].val()
};

/* Stringify your object */
json = JSON.stringify(obj);