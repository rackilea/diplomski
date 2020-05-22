function loadApplet(code,codebase,width,height,alt){
    var placeholder=document.getElementById('placeholder');
    var a = document.createElement('object');
    a.setAttribute('type','application/x-java-applet');
    a.setAttribute('width',width);
    a.setAttribute('height',height);
    a.setAttribute('alt',alt);

    var codeParam = document.createElement('param');
    codeParam.setAttribute('name','code');
    codeParam.setAttribute('value',code);
    a.appendChild(codeParam);

    var codebaseParam = document.createElement('param');
    codebaseParam.setAttribute('name','codebase');
    codebaseParam.setAttribute('value',codebase);
    a.appendChild(codebaseParam);

    placeholder.appendChild(a);
}