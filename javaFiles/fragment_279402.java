getDataFromServer1();
function void onCompleteServer1() {
    if(flag) {
       loadViews();
    } else {
       flag = true;
    }
}


getDataFromServer2();
onCompleteServer2Request() {
    if(flag) {
       loadViews();
    } else {
       flag = true;
    }
}