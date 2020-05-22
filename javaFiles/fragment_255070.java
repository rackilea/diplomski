File testFile = new File("./Mypath/myfile");
int buffer_size = 1024 * 1024
BufferedReader br = new BufferedReader(new FileReader(testFile), buffer_size);

StringBuilder bld = StringBuilder();
int c = br.read();

while(c != -1){
    char z = (char)c;
    if(z == '@'){
        System.out.println(bld);
        if(bld.length() > 0){
            bld.delete(0, bld.length() - 1);
        }
    } else {
        bld.append(z);
    }
}