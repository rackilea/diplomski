boolean check=false;
while (!check && PerConst.hasNextDouble()) {
    m = PerConst.nextDouble();
    if (m >= 0) 
        check=true;
    } else {
        System.out.println("Invalid number, Enter positive double: ");
    }
}
if(!check) {
    // System.in has reached EOF
}