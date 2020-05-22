else if (args[i].startsWith("Body:")) { 
    body = args[i].substring(5);    // **I'm stuck here**
    while(i < x) {
        i++;
        body += " " + args[i];
    }   
}