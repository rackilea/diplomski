$( document ).ready(function() {  
    SetImage();
    window.setInterval(SetImage,1000);
});

function SetImage(){     
    var nowdate = new Date() ;

    var waketime = new Date();     
    waketime.setHours(6);
    waketime.setMinutes(30);

    var bedtime = new Date();     
    bedtime.setHours(18);
    bedtime.setMinutes(30);

    if(waketime < nowdate  && nowdate < bedtime){
         $('#day').show();
         $('#night').hide();
    }else{
         $('#night').show();
         $('#day').hide();
    }
}