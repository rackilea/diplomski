outStream.write(outArray); 
// you already committed the response here by flushing the output stream
outStream.flush(); 

//block2
request.setAttribute("Message", str1);
request.setAttribute("MessageDetails", str2);
// this is illegal after you have already flushed the response
request.getRequestDispatcher("/MyFile.jsp").forward(request, response);