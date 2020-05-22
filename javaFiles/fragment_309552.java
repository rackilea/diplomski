function loadApplet(code,codebase,width,height,alt){
    var placeholder=document.getElementById('placeholder');
    if(window.opera){
        placeholder.innerHTML='<applet code="'+code+'" codebase="'+codebase+'" width="'+width+'" height="'+height+'" alt="'+alt+'"></applet>';
    }else{
        var a=document.createElement('applet');
        a.setAttribute('code',code);
        a.setAttribute('codebase',codebase);
        a.setAttribute('width',width);
        a.setAttribute('height',height);
        a.setAttribute('alt',alt);
        placeholder.appendChild(a);
    }
}