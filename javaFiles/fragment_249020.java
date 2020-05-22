for(int j = 0; j < arraySubs.length; j++) {
    if(j<arraySubs.length-1) {
        System.out.println("j:" + j);
        System.out.println("j val:" + arraySubs[j]);
        System.out.println("j+1 val:" + arraySubs[j+1]);
        if(arraySubs[j+1] != null && arraySubs[j+1].equalsIgnoreCase(arraySubs[j])) { // The FIX
            System.out.println("j val changed to null");
            arraySubs[j]=null;
        }   
    }
    if(arraySubs[j]!=null) {
        System.out.println(arraySubs[j]);
    } else {
        System.out.println("skipping null");
    }
}