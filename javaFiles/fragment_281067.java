int randomInvoice = Math.round(Math.random() * 1000000);
File myfile1 = new File("file" + randomInvoice); // create file 1
myfile1.createNewFile();
...
randomInvoice++; // increase
File myfile2 = new File("file" + randomInvoice);
myfile2.createNewFile(); // create file 2