Object content = msg.getContent();  
if (content instanceof String)  
{  
    String body = (String)content;  
    ...  
}  
else if (content instanceof Multipart)  
{  
    Multipart mp = (Multipart)content;  
    ...  
}